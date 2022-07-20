import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {SalesService} from "../../pages/sales/sales.service";
import {FormBuilder, FormGroup} from "@angular/forms";
import {DistrictsService} from "../../pages/districts/districts.service";
import {Districts} from "../../entities/districts";

@Component({
  selector: 'app-districts-dialog',
  templateUrl: './districts-dialog.component.html',
  styleUrls: ['./districts-dialog.component.sass']
})
export class DistrictsDialogComponent implements OnInit {

  pageForm!: FormGroup
  districts?: Districts[]
  option: number = 0

  constructor(private router: Router, private service: DistrictsService, private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.pageForm = this.fb.group({
      districtName: [''],
      description: [''],
    })
    this.option = Number(this.router.url.split('/').reverse()[0])
    if (this.option) {
      this.service.getOne(this.option).subscribe(data => {
        console.log("getOne districts", data)
        this.pageForm = this.fb.group({
          id: [data.id],
          districtName: [data.districtName],
          description: [data.description]
        })
      })
    }
  }

  save() {
    if (this.option) {
      console.log(<Districts>this.pageForm.value)
      this.service.changeData(<Districts>this.pageForm.value).subscribe(data => {
        console.log("createData district", data)
        this.router.navigate(['/district'])
      })
    } else {
      this.service.createData(<Districts>this.pageForm.value).subscribe(data => {
        console.log("createData district", data)
        this.router.navigate(['/district'])
      })
    }
  }

  back() {
    this.router.navigate(['/district'])
  }
}
