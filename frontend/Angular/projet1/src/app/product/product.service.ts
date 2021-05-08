import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {isObservable} from 'rxjs/internal-compatibility';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private URL = 'http://localhost:3000/product';

  constructor(private http: HttpClient) {
  }

  addProduct(data) {
    return this.http.post<any>(this.URL, data);
  }

  getProduct() {
    return this.http.get<any>(this.URL);
  }

  getSingleProduct(ID) {
    return this.http.get<any>(this.URL + '/' + ID);
  }
}
