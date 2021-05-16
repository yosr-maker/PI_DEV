import { User } from './../entity/user';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  baseUrl = "http://localhost:8082/SpringMVC/servlet/";

  register(user:User): Observable<any> {
    let uri="register";
    return this.http.post<any[]>(this.baseUrl+uri,user);
  }
}
