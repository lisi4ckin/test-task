import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {ReportService} from "./report.service";
import {Report} from "../../entities/report";

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.sass']
})
export class ReportComponent implements OnInit {

  dataSource: Report[] = []
  dataColumns: string[] = [];

  constructor(private service: ReportService, private router: Router) {
  }

  ngOnInit(): void {
    this.getData()
    this.dataColumns = ['district', 'sellerPhone', 'buyerPhone', 'income']
  }

  getData() {
    this.service.getData().subscribe(data => {
      this.dataSource = data
      console.log("getData report", data)
    })
  }

  download() {
    this.service.downloadReport().subscribe(data => {
      console.log("download report", data)
      let blob = new Blob([data], { type: 'text/csv' });
      let url= window.URL.createObjectURL(blob);
      window.open(url);
    })
  }
}
