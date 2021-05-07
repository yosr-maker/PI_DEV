import { Component, OnInit } from '@angular/core';
import { Product } from '../entity/Product';
import { ProductService } from '../services/product.service';


@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

list : Product[]


  constructor(private productService : ProductService) { }

  ngOnInit(): void {
    this.productService.getAllproduct().subscribe(data=>{
      this.list=data;
    })
  }

}
