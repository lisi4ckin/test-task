import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BuyerDialogComponent} from "./buyer-dialog.component";
import {RouterModule, Routes} from "@angular/router";
import {MatFormFieldModule} from "@angular/material/form-field";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatIconModule} from "@angular/material/icon";

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
        MatFormFieldModule,
        ReactiveFormsModule,
        MatInputModule,
        FormsModule,
        MatIconModule,
    ]
})
export class BuyerDialogModule { }
