import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../entity/Product';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  product: Product;
  constructor(private route: ActivatedRoute,
              private productService: ProductService) { }

  ngOnInit(): void {
    this.handleOneProduct();
  }


handleOneProduct() {

// get the "id" param string. convert string to a number using the "+" symbol
const theProductId: number = +this.route.snapshot.paramMap.get('id');

this.productService.getProductById(theProductId).subscribe(
data => {
this.product = data;
console.log(this.product)
}
)

}

}
