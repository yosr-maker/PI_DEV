import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Product } from '../entity/Product';
@Injectable({
  providedIn: 'root'
})
export class ProductService {
  urlAllprod=" ";

  constructor(private httpclient:HttpClient) { }


  public getAllproduct(){

    this.urlAllprod="http://localhost:8082/SpringMVC/servlet/getallprod";
    return this.httpclient.get<Product[]>(this.urlAllprod)
  }




  
  public addproduct(produt : Product){

    this.urlAllprod="http://localhost:8082/SpringMVC/servlet/add-product";
    return this.httpclient.post<Product>(this.urlAllprod,produt)
  }

}
