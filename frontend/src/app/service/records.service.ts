import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {MAIN_URL} from "./team.service";
import {Records} from "../dto/records";
import {Allrecords} from "../dto/allrecords";
import {All} from "tslint/lib/rules/completedDocsRule";

const URL = '/api/v1/records';
const URL2='/api/v1/allrecords/all/';
const URL3='/api/v1/allrecords';
@Injectable()
export class RecordsService {

  constructor(private http:HttpClient) { }



  getAllRecords(): Observable<Array<Allrecords>>{
    return this.http.get<Array<Allrecords>>(MAIN_URL + URL3);

  }

  getAllRecords2(studentName: string): Observable<Array<Allrecords>>{

    return this.http.get<Array<Allrecords>>(MAIN_URL + URL2+studentName);

  }

  saveRecords(record: Records): Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL + URL,record);
  }

  deleteRecords(studentName: string): Observable<boolean>{
    return this.http.delete<boolean>(MAIN_URL+ URL + "/" + studentName);
  }

  getTotalRecords(): Observable<number>{
    return this.http.get<number>(MAIN_URL + URL + "/count");
  }

  searchRecords(studentName :String): Observable<Records>{
    return this.http.get<Records>(MAIN_URL + URL + "/"+studentName);
  }



}
