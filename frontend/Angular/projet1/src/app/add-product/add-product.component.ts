import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
import {ProductService} from '../product/product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  constructor(private s: ProductService) {
  }

  ngOnInit(): void {
  }

  submit(f) {
    this.s.addProduct(f).subscribe(
      next =>
      console.log('cest bon')
    )
    ;
  }
}
