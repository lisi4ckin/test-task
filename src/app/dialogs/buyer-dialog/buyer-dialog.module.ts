import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BuyerDialogComponent} from "./buyer-dialog.component";
import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [
  {
    path: '',
    component: BuyerDialogComponent
  }
]

@NgModule({
  declarations: [
    BuyerDialogComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
  ]
})
export class BuyerDialogModule { }
