import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {SalesService} from "../../pages/sales/sales.service";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Districts} from "../../entities/districts";
import {Sales} from "../../entities/sales";
import {DistrictsService} from "../../pages/districts/districts.service";

@Component({
  selector: 'app-sales-dialog',
  templateUrl: './sales-dialog.component.html',
  styleUrls: ['./sales-dialog.component.sass']
})
export class SalesDialogComponent implements OnInit {

  @ViewChild('districtsName') districtsName?: ElementRef;

  pageForm!: FormGroup
  districts?: Districts[]
  element?: Sales
  option: number = 0

  constructor(
    private router: Router,
    private service: SalesService,
    private fb: FormBuilder,
    private serviceDistrict: DistrictsService) {
  }

  ngOnInit(): void {
    this.option = Number(this.router.url.split('/').reverse()[0])
    this.pageForm = this.fb.group({
      sellerName: [''],
      phone: [''],
      districtId: [''],
      countFloors: [''],
      floorNumber: [''],
      houseArea: [''],
      housePrice: ['']
    })
    if (this.option) {
      this.service.getOne(this.option).subscribe(data => {
        this.pageForm = this.fb.group({
          id: [data.id],
          sellerName: [data.sellerName],
          phone: [data.phone],
          districtId: [data.sellersDistrict],
          countFloors: [data.countFloors],
          floorNumber: [data.floorNumber],
          houseArea: [data.houseArea],
          housePrice: [data.housePrice]
        })
      })
    }
    this.serviceDistrict.getData().subscribe(data => {
      this.districts = data
      console.log("getData districts in sales", data)
    })
  }

  save() {
    this.pageForm.get("districtId")?.setValue(Number(this.districtsName?.nativeElement.value))
    console.log(this.pageForm.value)
    if(this.option) {
      this.service.changeData(<Sales>this.pageForm.value).subscribe(data => {
        console.log("createData sales", data)
        this.router.navigate(['/sales'])
      })
    }
    else {
      this.service.createData(<Sales>this.pageForm.value).subscribe(data => {
        console.log("createData sales", data)
        this.router.navigate(['/sales'])
      })
    }
  }

  back() {
    this.router.navigate(['/sales'])
  }
}
