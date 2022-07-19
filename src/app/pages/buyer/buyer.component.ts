import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {Buyers} from "../../entities/buyers";
import {BuyerService} from "./buyer.service";
import {Districts} from "../../entities/districts";

@Component({
  selector: 'app-buyer',
  templateUrl: './buyer.component.html',
  styleUrls: ['./buyer.component.sass']
})
export class BuyerComponent implements OnInit {

  dataSource: Buyers[] = []
  dataColumns: string[] = [];

  constructor(private service: BuyerService, private router: Router) {
  }

  ngOnInit(): void {
    this.getData()
    this.dataColumns = ['buyerName', 'buyerPhone', 'buyerDistricts', 'houseAreaGTE', 'houseAreaLTE', 'maxPrice', 'buyerFilters', 'change', 'delete']
  }

  getData() {
    this.service.getData().subscribe(data=>{
      this.dataSource = data
      console.log("getData buyer", data)
    })
  }

  delete(id: number) {
    this.service.deleteData(id).subscribe(data=>{
      console.log("delete buyer", data)
      location.reload()
    })
  }

  change(id: number) {
    this.router.navigate(['/buyerDialog/' + id])
  }

  create() {
    this.router.navigate(['/buyerDialog/0'])
  }

}
