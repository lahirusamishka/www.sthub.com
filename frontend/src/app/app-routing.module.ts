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
import {DashboardComponent} from "./view/dashboard/dashboard.component";


const appRoutes: Routes = [
  {path:'dashboard' ,component:DashboardComponent},

  {
    path: 'admin', component: AdminComponent, children: [
      {path: 'asignin', component: AsigninComponent},
      {path: 'asignup', component: AsignupComponent}
    ]
  },
  {path: 'home', component: HomeComponent,children:[

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



    ]},
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
