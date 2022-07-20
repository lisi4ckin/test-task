import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReportComponent } from './report.component';
import {RouterModule, Routes} from "@angular/router";
import {SalesComponent} from "../sales/sales.component";
import {MatTableModule} from "@angular/material/table";
import {MatIconModule} from "@angular/material/icon";

const routes: Routes = [
  {
    path: '',
    component: ReportComponent
  }
]

@NgModule({
  declarations: [
    ReportComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    MatTableModule,
    MatIconModule,
  ]
})
export class ReportModule { }
