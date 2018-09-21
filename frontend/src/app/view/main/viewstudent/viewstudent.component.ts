import { Component, OnInit } from '@angular/core';
import {StudentService} from "../../../service/student.service";
import {Allrecords} from "../../../dto/allrecords";
import {ParentService} from "../../../service/parent.service";
import {RecordsService} from "../../../service/records.service";

@Component({
  selector: 'app-viewstudent',
  templateUrl: './viewstudent.component.html',
  styleUrls: ['./viewstudent.component.css']
})
export class ViewstudentComponent implements OnInit {

  scrl: boolean = false;
  profileName: string = "No teacher";
  profileDiscription: string = "empty discription"
  studentName: string;


  selectedStudenRecord: Allrecords = new Allrecords();
  allrecords: Array<Allrecords> = [];


  constructor(private parentService: ParentService, private recordServicse: RecordsService,private studentService:StudentService) {
  }

  ngOnInit() {

    this.recordServicse.getAllRecords2(this.studentService.getStudentName()).subscribe(
      ((result) => {
        this.allrecords = result;

      })
    )
  }

  logout() {
    this.parentService.logout();





  }

  seacherStduent() {


    this.recordServicse.getAllRecords2(this.studentName).subscribe(
      ((result) => {
        this.allrecords = result;

      })
    )
  }

  selectRecord(records) {
    this.selectedStudenRecord = records;
  }



}
