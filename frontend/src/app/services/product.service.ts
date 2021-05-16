import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Product } from '../entity/Product';
import { Observable } from 'rxjs';
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

  getProductById(id:number): Observable<Product> 
  {
    this.urlAllprod="http://localhost:8082/SpringMVC/servlet/findproductById/"; 

    return this.httpclient.get<Product>(this.urlAllprod+id);
  }

  updateProduct(product: Product): Observable<Product> {

   this.urlAllprod=" http://localhost:8082/SpringMVC/servlet/updateproduct";
 
    return this.httpclient.put<Product>(this.urlAllprod, product);
  }
  
  deleteProduct(id: number): Observable<{}> {
    this.urlAllprod="http://localhost:8082/SpringMVC/servlet/deleteproduct/"

    
    return this.httpclient.delete(this.urlAllprod+id)
  }

}
