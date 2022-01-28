import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { AppModel } from './app.model';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  token = "";
  url = "http://localhost:8080/merchant/find";
  urlLogin = "http://localhost:8080/login";

  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    let user = JSON.stringify({ username, password });
    return this.http.post(this.urlLogin, user, { observe: 'response' })
  }

  getHeader() {    
    let Authorization = ""+localStorage.getItem("Authorization");
    const headers_object = new HttpHeaders({
      'Authorization': Authorization
    });
    return headers_object;
  }

  getMerchants(name = '', country='') {
    let params = {name: name, country: country};    
    return this.http.get<AppModel[]>( this.url, 
                                      { 
                                          headers: this.getHeader(),
                                          params,
                                          responseType: 'json'
                                      } 
                                    );
  }
}
