import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { CitizenLoginComponent } from './components/citizen-login/citizen-login.component';
import { HcaLoginComponent } from './components/hca-login/hca-login.component';
import { RegisterCitizenComponent } from './components/citizen-register/citizen-register.component';
import { HcaRegisterComponent } from './components/hca-register/hca-register.component';
import { CitizenDashboardComponent } from './components/citizen-dashboard/citizen-dashboard.component';
import { HcaDashboardComponent } from './components/hca-dashboard/hca-dashboard.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'ciztiens-login', component: CitizenLoginComponent },
  { path: 'citizen-dashboard', component: CitizenDashboardComponent },
  { path: 'citizens-registration', component: RegisterCitizenComponent },
  { path: 'hca-login', component: HcaLoginComponent },
  { path: 'hca-registration', component: HcaRegisterComponent },
  { path: 'hca-dashboard', component: HcaDashboardComponent },
  { path: '**', component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
