import { Component } from '@angular/core';

export type Routes = {title: string, path: string}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.sass']
})

export class HomeComponent {

  routes?: Routes[]

  constructor() {
    this.createRoutes()
  }

  createRoutes(){
    this.routes = [
      {
        path: '/sales',
        title: 'Продавцы'
      },
      {
        path: '/buyer',
        title: 'Покупатели'
      },
      {
        path: '/district',
        title: 'Справочник районов'
      },
      {
        path: '/result',
        title: 'Отчёт'
      }
    ]
  }

}
