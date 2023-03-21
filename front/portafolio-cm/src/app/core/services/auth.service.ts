import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  env = "http://localhost/8000/api/v1/";
  suffix = "login";

  constructor(
    private httpClient: HttpClient
  ) { 
  }

  postLogin(user: any):Observable<any>{
    return this.httpClient.post<any>("http://localhost:8000/api/v1/login", user);
  }
}
