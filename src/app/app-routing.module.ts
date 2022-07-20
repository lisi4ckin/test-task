import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: "",
    redirectTo: "/report",
    pathMatch: "full"
  },
  {
    path: "sales",
    loadChildren: () => import('./pages/sales/sales.module').then(m => m.SalesModule)
  },
  {
    path: "buyer",
    loadChildren: () => import('./pages/buyer/buyer.module').then(m => m.BuyerModule)
  },
  {
    path: "district",
    loadChildren: () => import('./pages/districts/districts.module').then(m => m.DistrictsModule)
  },
  {
    path: "report",
    loadChildren: () => import('./pages/report/report.module').then(m => m.ReportModule),
  },
  {
    path: "districtsDialog/:id",
    loadChildren: () => import('./dialogs/districts-dialog/districts-dialog.module').then(m => m.DistrictsDialogModule)
  },
  {
    path: "salesDialog/:id",
    loadChildren: () => import('./dialogs/sales-dialog/sales-dialog.module').then(m => m.SalesDialogModule),
  },
  {
    path: "buyerDialog/:id",
    loadChildren: () => import('./dialogs/buyer-dialog/buyer-dialog.module').then(m => m.BuyerDialogModule),
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
