import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Report} from "../../entities/report";

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  private httpOptions = {
    headers: new HttpHeaders({
      'Accept': 'application/xlsx, */*',
    }),
    'responseType': 'blob' as 'json'
  };

  constructor(private http: HttpClient) {
  }

  getData(): Observable<Report[]> {
    return this.http.get<Report[]>("/api/report")
  }

  downloadReport(): Observable<any> {
    return this.http.post<any>("/api/report/download", {}, this.httpOptions)
  }
}
