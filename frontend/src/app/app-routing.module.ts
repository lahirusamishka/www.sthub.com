import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./view/home/home.component";
import {AdminComponent} from "./view/admin/admin.component";
import {TeacherComponent} from "./view/teacher/teacher.component";
import {ParentComponent} from "./view/parent/parent.component";
import {TsigninComponent} from "./view/teacher/tsignin/tsignin.component";
import {TsignupComponent} from "./view/teacher/tsignup/tsignup.component";
import {PsigninComponent} from "./view/parent/psignin/psignin.component";
import {PsignupComponent} from "./view/parent/psignup/psignup.component";
import {AsigninComponent} from "./view/admin/asignin/asignin.component";
import {AsignupComponent} from "./view/admin/asignup/asignup.component";
import {AswitchComponent} from "./view/home/aswitch/aswitch.component";
import {DashboardComponent} from "./view/main/dashboard/dashboard.component";
import {AuthGuard} from "./guards/auth.guard";
import {MainComponent} from "./view/main/main.component";
import {Main2Component} from "./view/main2/main2.component";
import {ParentGuard} from "./guards/parent.guard";
import {DashboardParentComponent} from "./view/main2/dashboard-parent/dashboard-parent.component";
import {AdminGuard} from "./guards/admin.guard";
import {AdminDashboardComponent} from "./view/main3/admin-dashboard/admin-dashboard.component";
import {Main3Component} from "./view/main3/main3.component";
import {SettingsComponent} from "./view/main/settings/settings.component";
import {StudentManageComponent} from "./view/main/student-manage/student-manage.component";
import {LoginpageComponent} from "./view/loginpage/loginpage.component";
import {UpdatestudentComponent} from "./view/main/updatestudent/updatestudent.component";
import {ManageParentComponent} from "./view/main3/manage-parent/manage-parent.component";
import {ManageSettingsComponent} from "./view/main3/manage-settings/manage-settings.component";
import {ManageStudentComponent} from "./view/main3/manage-student/manage-student.component";
import {ManageTeacherComponent} from "./view/main3/manage-teacher/manage-teacher.component";
import {ManageTeamComponent} from "./view/main3/manage-team/manage-team.component";
import {RecodebookComponent} from "./view/main/recodebook/recodebook.component";
import {ViewstudentComponent} from "./view/main/viewstudent/viewstudent.component";


const appRoutes: Routes = [
  {
    path: "main",
    component: MainComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: "dashboard", component: DashboardComponent, children: [
          {path: "student-manage", component: StudentManageComponent}
        ]
      },
      {path: "settings", component: SettingsComponent},
      {path: "student-manage", component: StudentManageComponent},
      {path:"updatestudent",component: UpdatestudentComponent},
      {path:"recodebook",component:RecodebookComponent},
      {path:"viewstudent",component:ViewstudentComponent}
    ]
  },
  {
    path: "main2",
    component: Main2Component,
    canActivate: [ParentGuard],
    children: [
      {path: "dashboard-parent", component: DashboardParentComponent}
    ]
  },
  {
    path: "main3",
    component: Main3Component,
    canActivate: [AdminGuard],
    children: [
      {path: "admin-dashboard", component: AdminDashboardComponent},
      {path: "manage-parent",component:ManageParentComponent},
      {path: "manage-settings",component:ManageSettingsComponent},
      {path: "manage-student",component:ManageStudentComponent},
      {path: "manage-teacher",component:ManageTeacherComponent},
      {path: "manage-team",component:ManageTeamComponent}
    ]
  },
  {
    path: 'admin', component: AdminComponent, children: [
      {path: 'asignin', component: AsigninComponent},
      {path: 'asignup', component: AsignupComponent}
    ]
  },
  {
    path: 'home', component: HomeComponent
  },
  {
    path: 'loginpage', component: LoginpageComponent, children: [
      {
        path: 'teacher', component: TeacherComponent, children: [
          {path: 'tsignin', component: TsigninComponent},
          {path: 'tsignup', component: TsignupComponent}
        ]
      },
      {
        path: 'parent', component: ParentComponent, children: [
          {path: 'psignin', component: PsigninComponent},
          {path: 'psignup', component: PsignupComponent}
        ]
      }
    ]
  },

  {path: '', redirectTo: '/home', pathMatch: 'full'}
];


@NgModule({

  imports: [
    RouterModule.forRoot(appRoutes)
  ],

  exports: [
    RouterModule
  ],

})
export class AppRoutingModule {
}
