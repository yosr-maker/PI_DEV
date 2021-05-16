
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Event } from '../entity/event';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  baseUrl = "http://localhost:8082/SpringMVC/servlet/";

  constructor(private http: HttpClient) { }

  getUpcomingEvents(): Observable<any> {
    let uri="retrieve-upcoming-Events";
    return this.http.get<any[]>(this.baseUrl+uri);
  }

  getPassedEvents(): Observable<any> {
    let uri="retrieve-passed-Events";
    return this.http.get<any[]>(this.baseUrl+uri);
  }

  

  
  addEvent(event:Event): Observable<any> {
    let uri="add-Event/"
    return this.http.post<any[]>(this.baseUrl+uri,event);
  }

  deleteEvent(eventId:number): Observable<any> {
    let uri="delete-Event/"+eventId;
    return this.http.delete<any[]>(this.baseUrl+uri);
  }

  getEventParticipation(eventId:number): Observable<any> {
    let uri="participationsList/"+eventId;
    return this.http.get<any[]>(this.baseUrl+uri);
  }

  getClientParticipation(clientId:number): Observable<any> {
    let uri="clientParticipationsList/"+clientId;
    return this.http.get<any[]>(this.baseUrl+uri);
  }



  getEventList(): Observable<any> {
    let uri="retrieve-all-Events";
    return this.http.get<any[]>(this.baseUrl+uri);
  }

  addParticipation(eventId:number,clientId:number): Observable<any> {
    let uri="add-Participation/"+eventId+"/"+clientId;
    return this.http.get<any[]>(this.baseUrl+uri,{responseType: 'text' as 'json'});
  }

  addContribution(eventId:number,clientId:number,amount:number): Observable<any> {
    let uri="add-Contribution/"+eventId+"/"+clientId+"/"+amount;
    return this.http.post<any[]>(this.baseUrl+uri,null);
  }

  getEventByName(name:string): Observable<any> {
    let uri="retrieve-Event-ByName/"+name
    return this.http.get<any[]>(this.baseUrl+uri);
  }

  getEventByCategory(category:string): Observable<any> {
    let uri="retrieve-Events-ByCategory/"+category;
    return this.http.get<any[]>(this.baseUrl+uri);
  }

  displayBestEventsByParticipations(): Observable<any> {
    let uri="displayBestEventsByParticipations";
    return this.http.get<any[]>(this.baseUrl+uri);
  }

  displayBestEventsByCollects(): Observable<any> {
    let uri="displayBestEventsByCollects";
    return this.http.get<any[]>(this.baseUrl+uri);
  }
}
