import {Component, OnInit} from '@angular/core';
import {ParentService} from "../../service/parent.service";
import {Allrecords} from "../../dto/allrecords";
import {RecordsService} from "../../service/records.service";
import {Records} from "../../dto/records";

@Component({
  selector: 'app-main2',
  templateUrl: './main2.component.html',
  styleUrls: ['./main2.component.css']
})
export class Main2Component implements OnInit {

  scrl: boolean = false;
  profileName: string = "No teacher";
  profileDiscription: string = "empty discription"
  studentName: string;


  selectedStudenRecord: Allrecords = new Allrecords();
  allrecords: Array<Allrecords> = [];


  constructor(private parentService: ParentService, private recordServicse: RecordsService) {
  }

  ngOnInit() {
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
