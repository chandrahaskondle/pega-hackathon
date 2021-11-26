import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-hca-login',
  templateUrl: './hca-login.component.html',
  styleUrls: ['./hca-login.component.scss']
})
export class HcaLoginComponent implements OnInit {
  selectedHospital ='';
  
  constructor() { }

  ngOnInit(): void { }

}

interface Hospital {
  value: number;
  viewValue: string;
}