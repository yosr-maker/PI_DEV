import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  listProduct;

  constructor() {
  }

  ngOnInit(): void {
    this.listProduct = [
      {id: 1, title: 'PC 1', quantity: 10, like: 0, price: 20},
      {id: 2, title: 'PC 2', quantity: 0, like: 0, price: 30},
      {id: 3, title: 'PC 3', quantity: 20, like: 0, price: 100},
    ];
  }

  increaselike($event) {
    let i = this.listProduct.indexOf($event);
    console.log(i);
    this.listProduct[i].like++;

  }

  decreasequantity(msg) {
    let j = this.listProduct.indexOf(msg);
    this.listProduct[j].quantity--;
  }

}
