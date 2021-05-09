import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ProductService {
  urlAllprod="";

  constructor(private httpclient:HttpClient) { }


  public getAllproduct(){


    return this.httpclient.get(this.urlAllprod)
  }
}
