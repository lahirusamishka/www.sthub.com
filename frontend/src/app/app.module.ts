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
import {NgxPaginationModule} from "ngx-pagination";
import { TsigninComponent } from './view/teacher/tsignin/tsignin.component';
import { TsignupComponent } from './view/teacher/tsignup/tsignup.component';
import { AswitchComponent } from './view/home/aswitch/aswitch.component';
import { DashboardComponent } from './view/main/dashboard/dashboard.component';
import {BaseRequestOptions} from "@angular/http";
import {MockBackend} from "@angular/http/testing";
import { MainComponent } from './view/main/main.component';
import { Main2Component } from './view/main2/main2.component';
import {ParentService} from "./service/parent.service";
import {ParentGuard} from "./guards/parent.guard";
import { DashboardParentComponent } from './view/main2/dashboard-parent/dashboard-parent.component';
import { Main3Component } from './view/main3/main3.component';
import { AdminDashboardComponent } from './view/main3/admin-dashboard/admin-dashboard.component';
import {AdminGuard} from "./guards/admin.guard";
import {AdminService} from "./service/admin.service";
import { SettingsComponent } from './view/main/settings/settings.component';
import { StudentManageComponent } from './view/main/student-manage/student-manage.component';
import {TeamService} from "./service/team.service";
import { LoginpageComponent } from './view/loginpage/loginpage.component';
import { HomemainComponent } from './view/home/homemain/homemain.component';
import {StudentService} from "./service/student.service";
import { UpdatestudentComponent } from './view/main/updatestudent/updatestudent.component';
import { ManageStudentComponent } from './view/main3/manage-student/manage-student.component';
import { ManageTeacherComponent } from './view/main3/manage-teacher/manage-teacher.component';
import { ManageTeamComponent } from './view/main3/manage-team/manage-team.component';
import { ManageParentComponent } from './view/main3/manage-parent/manage-parent.component';
import { ManageSettingsComponent } from './view/main3/manage-settings/manage-settings.component';
import {SwalParams, SweetAlert} from "sweetalert/typings/core";
import {SweetAlertService} from "angular-sweetalert-service";
import {NgxAlertsService} from "ngx-alerts/lib/ngx-alerts.service";
import { RecodebookComponent } from './view/main/recodebook/recodebook.component';
import {RecordsService} from "./service/records.service";
import { StudentcatogoryComponent } from './view/home/studentcatogory/studentcatogory.component';
import { ViewstudentComponent } from './view/main/viewstudent/viewstudent.component';


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
    DashboardComponent,
    MainComponent,
    Main2Component,
    DashboardParentComponent,
    Main3Component,
    AdminDashboardComponent,
    SettingsComponent,
    StudentManageComponent,
    LoginpageComponent,
    HomemainComponent,
    UpdatestudentComponent,
    ManageStudentComponent,
    ManageTeacherComponent,
    ManageTeamComponent,
    ManageParentComponent,
    ManageSettingsComponent,
    RecodebookComponent,
    StudentcatogoryComponent,
    ViewstudentComponent,

  ],

  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    NgxPaginationModule,

  ],

  providers: [
    AuthGuard,
    AuthService,
    ParentGuard,
    ParentService,
    AdminGuard,
    AdminService,
    TeamService,
    StudentService,
    RecordsService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }



