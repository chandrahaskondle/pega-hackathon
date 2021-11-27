import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { DataService } from 'src/app/data.service';

@Component({
  selector: 'app-login',
  templateUrl: './citizen-login.component.html',
  styleUrls: ['./citizen-login.component.scss']
})
export class CitizenLoginComponent implements OnInit {
  citizenLoginForm: FormGroup;

  constructor(private fb: FormBuilder, public dataService: DataService) { }

  ngOnInit(): void {
    this.citizenLoginForm = this.fb.group({
      phoneNumber: "",
      password: ""
    });
  }

  citizenLogin(value) {
    this.dataService.citizenLogin(value);
  }

}
