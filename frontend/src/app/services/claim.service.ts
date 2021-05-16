import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Claim } from '../entity/claim';

@Injectable({
  providedIn: 'root'
})
export class ClaimService {

  baseUrl = "http://localhost:8082/SpringMVC/servlet/";

  constructor(private http: HttpClient) { }


  addClaim(claim:Claim,productId:number,clientId:number): Observable<any> {
    let uri="addClaim/"+productId+"/"+clientId;
    return this.http.post<any[]>(this.baseUrl+uri,claim);
  }

  
  deleteClaim(claimId:number): Observable<any> {
    let uri="remove-claim/"+claimId;
    return this.http.delete<any[]>(this.baseUrl+uri);
  }

  getClaimList(): Observable<any> {
    let uri="retrieve-all-claims";
    return this.http.get<any[]>(this.baseUrl+uri);
  }

  
  displayBadProductsByClaims(): Observable<any> {
    let uri="displayBadProductsByClaims";
    return this.http.get<any[]>(this.baseUrl+uri);
  }
}
