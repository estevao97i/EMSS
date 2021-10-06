import { environment } from './../../environments/environment.prod';
import { SelectItem } from 'primeng';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MotivoService {

  constructor(private http: HttpClient) { }

  baseUrl: string = environment.apiUrl + '/motivos';

  public listar(): Observable<SelectItem[]>{
    const url = this.baseUrl 
    return this.http.get<SelectItem[]>(url);
  }
}