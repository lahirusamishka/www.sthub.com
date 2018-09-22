import {Component, OnInit, ViewChild} from '@angular/core';
import {ParentService} from "../../../service/parent.service";
import {Parent} from "../../../dto/parent";
import {NgForm} from "@angular/forms";
import {Team} from "../../../dto/team";

@Component({
  selector: 'app-manage-parent',
  templateUrl: './manage-parent.component.html',
  styleUrls: ['./manage-parent.component.css']
})
export class ManageParentComponent implements OnInit {

  @ViewChild("parentForm") parentForm: NgForm;
  manuallySelected: boolean = false;
  savedmsg: boolean;
  parent: Parent = new Parent();
  parentss: Array<Parent> = [];
  searchParents: Parent = new Parent();
  tempParent: Parent = null;
  constructor(private parentservice: ParentService) {
  }

  ngOnInit() {
     this.loadAllteacher();

  }

  deleteParent(paren:String){
    this.parentservice.deleteParent(this.parent.name).subscribe(
      ((result)=>{
         alert("deleted");
        this.loadAllteacher();
      })
    )
  }

  closeAlert() {
    this.savedmsg = false;
  }


  saveParent() {
    this.parentservice.saveParent(this.parent).subscribe(
      ((result) => {
        alert("sucees")
      })
    )
  }

  selectTeam(paren:Parent){
    this.parent = paren;
    this.tempParent = Object.assign({}, paren);
    this.manuallySelected = true;
  }

  searchParent() {


    this.parentservice.searchParent(this.searchParents.name).subscribe(
      ((result) => {
        this.parent = result;
      })
    )
  }

  private loadAllteacher() {
    this.parentservice.getAllParents().subscribe(
      ((resul)=>{
        this.parentss=resul;
      })
    )
  }
}
