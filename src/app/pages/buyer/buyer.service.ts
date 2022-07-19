import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Sales} from "../../entities/sales";
import {Buyers} from "../../entities/buyers";

@Injectable({
  providedIn: 'root'
})
export class BuyerService {

  constructor(private http: HttpClient) {
  }

  getData(): Observable<Buyers[]> {
    return this.http.get<Buyers[]>("/api/buyer")
  }

  changeData(buyer: any): Observable<any> {
    return this.http.put('/api/buyer', buyer)
  }

  createData(buyer: any): Observable<any> {
    return this.http.post('/api/buyer', buyer)
  }

  deleteData(id: number): Observable<any> {
    return this.http.delete('/api/buyer/' + id)
  }

  getOne(id: number): Observable<Buyers>{
    return this.http.get<Buyers>('/api/buyer/' + id)
  }
}
