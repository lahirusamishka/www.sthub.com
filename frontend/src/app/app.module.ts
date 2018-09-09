import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AdminComponent } from './view/admin/admin.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {AppRoutingModule} from "./app-routing.module";
import {AuthGuard} from "./guards/auth.guard";
import {AuthService} from "./service/auth.service";
import { HomeComponent } from './view/home/home.component';
import { NavbarComponent } from './view/home/navbar/navbar.component';
import { SliderbarComponent } from './view/home/sliderbar/sliderbar.component';
import { AboutusComponent } from './view/home/aboutus/aboutus.component';
import { OurserviceComponent } from './view/home/ourservice/ourservice.component';
import { OurcoursesComponent } from './view/home/ourcourses/ourcourses.component';
import { ContactusComponent } from './view/home/contactus/contactus.component';
import { FooterComponent } from './view/home/footer/footer.component';
import { TeacherComponent } from './view/teacher/teacher.component';
import { ParentComponent } from './view/parent/parent.component';
import { AsigninComponent } from './view/admin/asignin/asignin.component';
import { AsignupComponent } from './view/admin/asignup/asignup.component';
import { PsigninComponent } from './view/parent/psignin/psignin.component';
import { PsignupComponent } from './view/parent/psignup/psignup.component';
import { TsigninComponent } from './view/teacher/tsignin/tsignin.component';
import { TsignupComponent } from './view/teacher/tsignup/tsignup.component';
import { AswitchComponent } from './view/home/aswitch/aswitch.component';
import { DashboardComponent } from './view/dashboard/dashboard.component';
import {BaseRequestOptions} from "@angular/http";
import {MockBackend} from "@angular/http/testing";


@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    HomeComponent,
    NavbarComponent,
    SliderbarComponent,
    AboutusComponent,
    OurserviceComponent,
    OurcoursesComponent,
    ContactusComponent,
    FooterComponent,
    TeacherComponent,
    ParentComponent,
    AsigninComponent,
    AsignupComponent,
    PsigninComponent,
    PsignupComponent,
    TsigninComponent,
    TsignupComponent,
    AswitchComponent,
    DashboardComponent
  ],

  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],

  providers: [
    AuthGuard,
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
