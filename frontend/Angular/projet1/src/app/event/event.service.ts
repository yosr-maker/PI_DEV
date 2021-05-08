import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventService {
  private URL = 'http://localhost:8082/PiDev/add-event';

  constructor(private http: HttpClient) {
  }

  addEvent(data) {
    return this.http.post<any>(this.URL, data);
  }

  getEvent() {
    return this.http.get<any>(this.URL);
  }

  getAllEventsById(id: number): Observable<Event[]> {
    return this.http.get<Event[]>('http://localhost:8082/PiDev/retrieve-Event-ById/1' + id);

  }


  getSingleEventN(Name) {
    return this.http.get<any>(this.URL + '/' + Name);
  }

  getSingleEventC(Category) {
    return this.http.get<any>(this.URL + '/' + Category);
  }

  deleteEventById(id: number) {
    return this.http.delete('http://localhost:8082/PiDev/delete-Event/1' + id);
  }
}
