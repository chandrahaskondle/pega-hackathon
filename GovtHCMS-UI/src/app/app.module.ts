import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MDBBootstrapModule } from 'angular-bootstrap-md';

import { AppRoutingModule } from './app-routing.module';
import { MatSelectModule } from '@angular/material/select';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { LoginCitizenComponent } from './components/login-citizen/login-citizen.component';
import { RegisterCitizenComponent } from './components/register-citizen/register-citizen.component';
import { LoginHcAdminComponent } from './components/login-hc-admin/login-hc-admin.component';
import { RegisterHcAdminComponent } from './components/register-hc-admin/register-hc-admin.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginCitizenComponent,
    RegisterCitizenComponent,
    LoginHcAdminComponent,
    RegisterHcAdminComponent
  ],
  imports: [
    MatSelectModule,
    BrowserModule,
    AppRoutingModule,
    MDBBootstrapModule.forRoot(),
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
