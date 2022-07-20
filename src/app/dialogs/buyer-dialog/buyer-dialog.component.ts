import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Districts} from "../../entities/districts";
import {Sales} from "../../entities/sales";
import {Router} from "@angular/router";
import {SalesService} from "../../pages/sales/sales.service";
import {DistrictsService} from "../../pages/districts/districts.service";
import {BuyerService} from "../../pages/buyer/buyer.service";

@Component({
  selector: 'app-buyer-dialog',
  templateUrl: './buyer-dialog.component.html',
  styleUrls: ['./buyer-dialog.component.sass']
})
export class BuyerDialogComponent implements OnInit {

  @ViewChild('districtsName') districtsName?: ElementRef;
  @ViewChild('filter') filter?: ElementRef;
  pageForm!: FormGroup
  districts?: Districts[]
  element?: Sales
  option: number = 0
  filters = [{id: 0, title: "любой этаж"}, {id: 1, title: "первый и последний этаж не предлагать"}]

  constructor(
    private router: Router,
    private service: BuyerService,
    private fb: FormBuilder,
    private serviceDistrict: DistrictsService) {
  }

  ngOnInit(): void {
    this.option = Number(this.router.url.split('/').reverse()[0])
    this.pageForm = this.fb.group({
      buyerName: [''],
      buyerPhone: [''],
      buyerDistrictsId: [''],
      buyerFilters: [''],
      houseAreaGTE: [''],
      houseAreaLTE: [''],
      maxPrice: ['']
    })
    if (this.option) {
      this.service.getOne(this.option).subscribe(data => {
        console.log("getOne districts in buyers", data)
        this.pageForm = this.fb.group({
          id: [data.id],
          buyerName: [data.buyerName],
          buyerPhone: [data.buyerPhone],
          buyerDistrictsId: [data.buyerDistricts],
          buyerFilters: [data.buyerFilters],
          houseAreaGTE: [data.houseAreaGTE],
          houseAreaLTE: [data.houseAreaLTE],
          maxPrice: [data.maxPrice]
        })
      })
    }
    this.serviceDistrict.getData().subscribe(data => {
      this.districts = data
      console.log("getData districts in buyers", data)
    })
  }

  save() {
    this.pageForm.get("buyerDistrictsId")?.setValue([Number(this.districtsName?.nativeElement.value)])
    this.pageForm.get("buyerFilters")?.setValue(Number(this.filter?.nativeElement.value))
    console.log(this.pageForm.value)
    if (this.option) {
      this.service.changeData(<Sales>this.pageForm.value).subscribe(data => {
        console.log("createData sales", data)
        this.router.navigate(['/buyer'])
      })
    } else {
      this.service.createData(<Sales>this.pageForm.value).subscribe(data => {
        console.log("createData sales", data)
        this.router.navigate(['/buyer'])
      })
    }
  }

  back() {
    this.router.navigate(['/buyer'])
  }

}
