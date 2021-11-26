import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hca-register',
  templateUrl: './hca-register.component.html',
  styleUrls: ['./hca-register.component.scss']
})
export class HcaRegisterComponent implements OnInit {
  selectedHospital ='';
  
  constructor() { }

  ngOnInit(): void {
  }

}
