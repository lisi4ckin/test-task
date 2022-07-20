import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Report} from "../../entities/report";

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  constructor(private http: HttpClient) { }

  getData(): Observable<Report[]>{
    return this.http.get<Report[]>("/api/report")
  }

  downloadReport(): Observable<any>{
    return this.http.get<any>("/api/download")
  }
}
