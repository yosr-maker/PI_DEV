import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  URL = 'http://localhost:3000/users';

  constructor(private http: HttpClient) {
  }

  getUsers() {
    return this.http.get<any>(this.URL);
  }

  addUser(data) {
    this.http.post<any>(this.URL, data);

  }
}
