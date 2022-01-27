import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Person } from './person';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { degree } from './degree';
 
@Injectable({providedIn:'root'})
export class ApiService {
 
  baseURL: string = "http://localhost:8090/degree/";
  delURL: string = "http://localhost:8090/degree/del/";
 
  constructor(private http: HttpClient) {
  }
 
  getDegree(): Observable<degree[]> {
    console.log('getAllDegrees '+this.baseURL + 'allDegree')
    return this.http.get<degree[]>(this.baseURL + 'allDegree')
  }

  getDegreeById(num: number): Observable<degree> {
    console.log('get degree no# ' + num + ' ' + this.baseURL + '{id}?id=' + num)
    return this.http.get<degree>(this.baseURL + num)
  }


  addDegree(degree:degree): Observable<any> {
    const headers = { 'content-type': 'application/json'}  
    const body=JSON.stringify(degree);
    console.log(body)
    return this.http.post(this.baseURL+'addDegree' , body, {'headers':headers})
  }

  updateDegree(num: number, name : string): Observable<any> {
    const headers = { 'content-type': 'application/json'}  
    console.log('updation performed on' + name)
    const data = name;
   // return this.http.post(this.heroesUrl, data, requestOptions);
    return this.http.put(this.baseURL+ num , data, {'headers':headers})
  }


  deleteDegree(x: number): Observable<any> {
    // const headers = { 'content-type': 'application/json'}  
     const body = x;
    console.log('delete API called ' + x);
    return this.http.delete(this.delURL+x)
  }
 
}