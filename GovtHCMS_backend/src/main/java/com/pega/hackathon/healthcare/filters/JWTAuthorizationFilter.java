package com.pega.hackathon.healthcare.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.pega.hackathon.healthcare.constants.SecurityConstants;
import com.pega.hackathon.healthcare.model.CitizenUser;
import com.pega.hackathon.healthcare.model.HealthCareProvider;
import com.pega.hackathon.healthcare.model.User;
import com.pega.hackathon.healthcare.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private UserRepository userRepository;

    public JWTAuthorizationFilter(AuthenticationManager authManager, UserRepository userRepository) {
        super(authManager);
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(SecurityConstants.HEADER_STRING);

        if (header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    // Reads the JWT from the Authorization header, and then uses JWT to validate the token
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(SecurityConstants.HEADER_STRING);

        if (token != null) {
            // parse the token.
            String userName = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()))
                    .build()
                    .verify(token.replace(SecurityConstants.TOKEN_PREFIX, ""))
                    .getSubject();
            User user = userRepository.findByUserName(userName);
            List<GrantedAuthority> roles;
            if (user instanceof CitizenUser) {
                roles = Collections.singletonList(new SimpleGrantedAuthority("citizen"));
            } else if (user instanceof HealthCareProvider) {
                roles = Collections.singletonList(new SimpleGrantedAuthority("provider"));
            } else {
                roles = Collections.singletonList(new SimpleGrantedAuthority("admin"));
            }

            if (userName != null) {
                // new arraylist means authorities
                return new UsernamePasswordAuthenticationToken(user, null, roles);
            }

            return null;
        }

        return null;
    }
}
