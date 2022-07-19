import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Sales} from "../../entities/sales";
import {Districts} from "../../entities/districts";

@Injectable({
  providedIn: 'root'
})
export class DistrictsService {

  constructor(private http: HttpClient) { }

  getData(): Observable<Districts[]> {
    return this.http.get<Districts[]>("/api/district")
  }

  changeData(district: Districts): Observable<any> {
    return this.http.put('/api/district', district)
  }

  createData(district: Districts): Observable<any> {
    return this.http.post('/api/district', district)
  }

  deleteData(id: number): Observable<any> {
    return this.http.delete('/api/district/' + id)
  }

  getOne(id: number): Observable<Districts>{
    return this.http.get<Districts>('/api/district/' + id)
  }
}
