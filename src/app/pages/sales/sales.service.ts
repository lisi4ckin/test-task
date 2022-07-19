import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Sales} from "../../entities/sales";

@Injectable({
  providedIn: 'root'
})
export class SalesService {

  constructor(private http: HttpClient) {
  }

  getData(): Observable<Sales[]> {
    return this.http.get<Sales[]>("/api/seller")
  }

  changeData(salerman: any): Observable<any> {
    return this.http.put('/api/seller', salerman)
  }

  createData(salerman: any): Observable<any> {
    return this.http.post('/api/seller', salerman)
  }

  deleteData(id: number): Observable<any> {
    return this.http.delete('/api/seller/' + id)
  }

  getOne(id: number): Observable<any>{
    return this.http.get('/api/seller/' + id)
  }

}
