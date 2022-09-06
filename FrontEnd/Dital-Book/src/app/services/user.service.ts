import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const URL = "localhost:9004/api/v1/digitalbooks/author/signup";
@Injectable({
  providedIn: 'root'
})

export class UserService {

  constructor(public http: HttpClient) { }

  save(user: any) {
    return this.http.post(URL, user);
  }

}
