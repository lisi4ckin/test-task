import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {SalesService} from "./sales.service";
import {MatDialog} from "@angular/material/dialog";
import {Router} from "@angular/router";
import {Sales} from "../../entities/sales";
import {Districts} from "../../entities/districts";
import {DistrictsService} from "../districts/districts.service";

@Component({
  selector: 'app-sales',
  templateUrl: './sales.component.html',
  styleUrls: ['./sales.component.sass']
})
export class SalesComponent implements OnInit {

  dataSource: Sales[] = []
  dataColumns: string[] = [];

  constructor(private service: SalesService, private router: Router) {
  }

  ngOnInit(): void {
    this.getData()
    this.dataColumns = ['sellerName', 'phone', 'sellerDistrict', 'countFloors', 'floorNumber', 'houseArea', 'housePrice', 'change', 'delete']
  }

  getData() {
    this.service.getData().subscribe(data=>{
      this.dataSource = data
      console.log("getData sales", data)
    })
  }

  delete(id: number) {
    this.service.deleteData(id).subscribe(data=>{
      console.log("delete sales", data)
      location.reload()
    })
  }

  change(id: number) {
    this.router.navigate(['/salesDialog/' + id])
  }

  create() {
    this.router.navigate(['/salesDialog/0'])
  }
}
