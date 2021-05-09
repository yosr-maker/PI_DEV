import { Component, OnInit } from '@angular/core';
import { Product } from '../entity/Product';
import { StockDetail } from '../entity/StockDetail';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-admin-products',
  templateUrl: './admin-products.component.html',
  styleUrls: ['./admin-products.component.css']
})
export class AdminProductsComponent implements OnInit {

  liste : boolean;
  ajouter : boolean;
  product : Product = new Product();
  stockDetail : StockDetail = new StockDetail();

  constructor(private serviceproduct : ProductService) { 
    this.liste = true;
    this.ajouter = false;

  }

  ngOnInit(): void {
  }

  toggleAjouter(){
    this.liste = false;
    this.ajouter = true;
  }

  toggleListe(){
    this.ajouter = false;
    this.liste = true;
  }

  ajouterProd(){
    console.log(this.product)
    this.product.stockDetail= this.stockDetail;
   this.product.stockDetail
   //console.log(this.product.stockDetail)
    this.serviceproduct.addproduct(this.product).subscribe();
    this.toggleListe();
  }

}
