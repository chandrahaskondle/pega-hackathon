import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginCitizenComponent } from './components/login-citizen/login-citizen.component';
import { LoginHcAdminComponent } from './components/login-hc-admin/login-hc-admin.component';
import { RegisterCitizenComponent } from './components/register-citizen/register-citizen.component';
import { RegisterHcAdminComponent } from './components/register-hc-admin/register-hc-admin.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'login-citizens', component: LoginCitizenComponent },
  { path: 'login-admins', component: LoginHcAdminComponent },
  { path: 'register-citizens', component: RegisterCitizenComponent },
  { path: 'register-admins', component: RegisterHcAdminComponent },
  { path: '**', component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
