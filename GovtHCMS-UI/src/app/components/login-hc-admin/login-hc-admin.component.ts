import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login-hc-admin',
  templateUrl: './login-hc-admin.component.html',
  styleUrls: ['./login-hc-admin.component.scss']
})
export class LoginHcAdminComponent implements OnInit {
  selected = 'option2';
  constructor() { }

  ngOnInit(): void {
  }

}
