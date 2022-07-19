import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DistrictsComponent } from './districts.component';
import {RouterModule, Routes} from "@angular/router";
import {SalesComponent} from "../sales/sales.component";
import {MatButtonModule} from "@angular/material/button";
import {MatTableModule} from "@angular/material/table";
import {MatIconModule} from "@angular/material/icon";

const routes: Routes = [
  {
    path: '',
    component: DistrictsComponent
  }
]

@NgModule({
  declarations: [
    DistrictsComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    MatButtonModule,
    MatTableModule,
    MatIconModule,
  ]
})
export class DistrictsModule { }
