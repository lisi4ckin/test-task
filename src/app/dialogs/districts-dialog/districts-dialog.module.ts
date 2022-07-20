import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DistrictsDialogComponent } from './districts-dialog.component';
import {RouterModule, Routes} from "@angular/router";
import {SalesDialogComponent} from "../sales-dialog/sales-dialog.component";
import {ReactiveFormsModule} from "@angular/forms";
import {MatIconModule} from "@angular/material/icon";

const routes: Routes = [
  {
    path: '',
    component: DistrictsDialogComponent
  }
]

@NgModule({
  declarations: [
    DistrictsDialogComponent
  ],
    imports: [
        CommonModule,
        RouterModule.forChild(routes),
        ReactiveFormsModule,
        MatIconModule,
    ]
})
export class DistrictsDialogModule { }
