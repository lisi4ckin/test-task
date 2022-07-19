import {Component, OnInit} from '@angular/core';
import {Districts} from "../../entities/districts";
import {DistrictsService} from "./districts.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-districts',
  templateUrl: './districts.component.html',
  styleUrls: ['./districts.component.sass']
})
export class DistrictsComponent implements OnInit {

  dataSource: Districts[] = []
  dataColumns: string[] = []

  constructor(private service: DistrictsService, private router: Router) {
  }

  ngOnInit(): void {
    this.getData()
    this.dataColumns = ['districtName', 'description', 'change', 'delete']
  }

  getData() {
    this.service.getData().subscribe(data => {
      this.dataSource = data
      console.log("getData district", data)
    })
  }

  change(id: number) {
    this.router.navigate(['/districtsDialog/' + id])
  }

  delete(id: number) {
    this.service.deleteData(id).subscribe(data => {
      console.log("delete district", data);
      this.getData()
    })
  }

  create() {
    this.router.navigate(['/districtsDialog/0'])
  }
}
