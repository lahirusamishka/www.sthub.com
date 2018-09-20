import {Component, OnInit, ViewChild} from '@angular/core';
import {RecordsService} from "../../../service/records.service";
import {Records} from "../../../dto/records";
import {NgForm} from "@angular/forms";
import {StudentService} from "../../../service/student.service";

@Component({
  selector: 'app-recodebook',
  templateUrl: './recodebook.component.html',
  styleUrls: ['./recodebook.component.css']
})
export class RecodebookComponent implements OnInit {

  examType: string;
  marksRange: string;

  searchbar;
  alert3: boolean=false;
  seaechNumber: number;
  stdeuntName: String;

  records: Array<Records> = [];
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
