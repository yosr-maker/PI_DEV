import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ContributionService {

  constructor(private http: HttpClient) { }


  baseUrl = "http://localhost:8082/SpringMVC/servlet/";

  getClientContribution(clientId:number): Observable<any> {
    let uri="clientContributionList/"+clientId;
    return this.http.get<any[]>(this.baseUrl+uri);
  }
}
