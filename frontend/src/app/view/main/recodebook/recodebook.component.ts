import {Component, OnInit, ViewChild} from '@angular/core';
import {RecordsService} from "../../../service/records.service";
import {Records} from "../../../dto/records";
import {NgForm} from "@angular/forms";
import {StudentService} from "../../../service/student.service";
import {Student} from "../../../dto/student";

@Component({
  selector: 'app-recodebook',
  templateUrl: './recodebook.component.html',
  styleUrls: ['./recodebook.component.css']
})
export class RecodebookComponent implements OnInit {

  examType: string;
  marksRange: string;
  tempTeam: Student = null;
  searchbar;
  alert3: boolean=false;
  seaechNumber: number;
  stdeuntName: String;
  teamid:number;



  records: Array<Records> = [];

  studentsbyTeam:Array<Student> =[];

  student:Student     = new Student();

  selectedRecord: Records = new Records();







  @ViewChild("frmRecordBook") frmRecordBook: NgForm;
  tempRecord: Records = null;
  manuallySelected: boolean = false;

  constructor(private recrordBookService: RecordsService, private studentServioce: StudentService) {
  }

  ngOnInit() {

    this.recrordBookService.getAllRecords().subscribe(
      ((result) => {
        this.records = result;
      })
    )

    this.selectedRecord.studentName = this.studentServioce.getStudentName();


    this.teamid=this.studentServioce.getTeamIds();

    this.lordAllStduentByeTeamId(this.teamid);

  }

  selectStudents(student: Student): void {

    this.selectedRecord.studentName=student.studentname;

    this.student = student;
    this.tempTeam = Object.assign({}, student);
    this.manuallySelected = true;
  }


  private lordAllStduentByeTeamId(teamId:number) {

    this.studentServioce.getAllStduentByTeamId(teamId).subscribe(
      ((result)=>{


        this.studentsbyTeam=result;

      })
    )
  }


  saveRecordBook() {


    this.recrordBookService.saveRecords(this.selectedRecord).subscribe(
      ((result) => {

        this.alert3 = result;
      })
    )
  }

  hiddin() {
    this.alert3 = false;
  }

  searchTeam() {

  }


}
