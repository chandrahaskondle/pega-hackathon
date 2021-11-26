import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { MatExpansionModule } from '@angular/material/expansion';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from 	'@angular/material/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { CitizenLoginComponent } from './components/citizen-login/citizen-login.component';
import { RegisterCitizenComponent } from './components/citizen-register/citizen-register.component';
import { HcaLoginComponent } from './components/hca-login/hca-login.component';
import { HcaRegisterComponent } from './components/hca-register/hca-register.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CitizenDashboardComponent } from './components/citizen-dashboard/citizen-dashboard.component';
import { HcaDashboardComponent } from './components/hca-dashboard/hca-dashboard.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CitizenLoginComponent,
    RegisterCitizenComponent,
    HcaLoginComponent,
    HcaRegisterComponent,
    CitizenDashboardComponent,
    HcaDashboardComponent
  ],
  imports: [
    FormsModule,
    ReactiveFormsModule,
    MatSelectModule,
    MatExpansionModule,
    MatDatepickerModule,
    MatNativeDateModule,
    BrowserModule,
    AppRoutingModule,
    MDBBootstrapModule.forRoot(),
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
