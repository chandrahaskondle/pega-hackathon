import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  apiUrl: string = 'http://localhost:8070';
  headers = new HttpHeaders().set('Content-Type', 'application/json');


  constructor(private httpClient: HttpClient) { }

  citizenLogin(value) {
    let postId = "";
    let data = { userName: value.phoneNumber, password: value.password };
    let url = this.apiUrl + "/user/citizen/loginUser";
    this.httpClient.post<any>(url, data).subscribe(data => {
      postId = data.id;
      console.log(postId)
    });
    //return this.httpClient.post(this.apiUrl+"/user/citizen/loginUser", data).pipe(catchError(this.handleError));
  }

  citizenRegisteration(value) {
    let data = { userName: value.phoneNumber, password: value.password };
    return this.httpClient.post(this.apiUrl + "/register", data).pipe(catchError(this.handleError));
  }


  hcaLogin(phno: number, password: String) {
    return this.httpClient.post(this.apiUrl + "/", "").pipe(catchError(this.handleError));
  }


  list(): Observable<any> {
    return this.httpClient.get(this.apiUrl).pipe(
      catchError(this.handleError)
    );
  }

  // Create new item
  getItem(id: any): Observable<any> {
    return this.httpClient.get(`${this.apiUrl}/${id}`).pipe(
      catchError(this.handleError)
    );
  }

  create(data: any): Observable<any> {
    return this.httpClient.post(this.apiUrl, data).pipe(
      catchError(this.handleError)
    );
  }

  // Edit/ Update 
  update(id: any, data: any): Observable<any> {
    return this.httpClient.put(`${this.apiUrl}/${id}`, data).pipe(
      catchError(this.handleError)
    );
  }

  // Delete
  delete(id: any): Observable<any> {
    return this.httpClient.delete(`${this.apiUrl}/${id}`).pipe(
      catchError(this.handleError)
    );
  }

  // Search By Name
  filterByTitle(title: any): Observable<any> {
    return this.httpClient.get(`${this.apiUrl}?title_like=${title}`).pipe(
      catchError(this.handleError)
    );
  }

  // Handle API errors
  handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    return throwError(
      'Something bad happened; please try again later.');
  };

}