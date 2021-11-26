package com.pega.hackathon.healthcare.service.impl;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.text.*;
import com.pega.hackathon.healthcare.model.CitizenUser;
import com.pega.hackathon.healthcare.model.Vaccination;
import com.pega.hackathon.healthcare.repositories.CitizenUserRepository;
import com.pega.hackathon.healthcare.repositories.VaccinationRepository;
import com.pega.hackathon.healthcare.service.UserService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.MessageFormat;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CitizenUserRepository citizenUserRepository;

    @Autowired
    private VaccinationRepository vaccinationRepository;

    public void registerUser(CitizenUser citizenUser) {
        citizenUser.setPassword(bCryptPasswordEncoder.encode(citizenUser.getPassword()));
        citizenUserRepository.save(citizenUser);
    }

    @Override
    public ByteArrayInputStream generatePDF(int id) throws IOException {
        Document document = new Document(PageSize.A4.rotate());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        document.addTitle("Vaccine Certificate");


        Vaccination vaccination = vaccinationRepository.findByAppointmentId(id);
        InputStream is = this.getClass().getResourceAsStream("/template.html");
        assert is != null;
        String htmlString = IOUtils.toString(is, StandardCharsets.UTF_8);
        htmlString = MessageFormat.format(htmlString, vaccination.getUser().getFirstName(), vaccination.getVaccine().getName(), vaccination.getDateOfVaccination(), vaccination.getHealthCareProvider(), vaccination.getLocation());
        File htmlSource = File.createTempFile("source", ".html");
        FileUtils.writeStringToFile(htmlSource, htmlString);
        File pdfDest = File.createTempFile("output", ".pdf");
        ConverterProperties converterProperties = new ConverterProperties();
        HtmlConverter.convertToPdf(new FileInputStream(htmlSource),
                new FileOutputStream(pdfDest), converterProperties);
        return new ByteArrayInputStream(Files.readAllBytes(pdfDest.toPath()));
    }
}
