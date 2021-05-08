import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form-product',
  templateUrl: './form-product.component.html',
  styleUrls: ['./form-product.component.css']
})
export class FormProductComponent implements OnInit {
  product = [];

  constructor() {
  }

  ngOnInit(): void {
  }

  save(form) {
    this.product.push(form);
    console.log(this.product);
    console.log(form);

  }
}
