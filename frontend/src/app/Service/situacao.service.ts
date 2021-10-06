import { environment } from './../../environments/environment.prod';
import { SelectItem } from 'primeng';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SituacaoService {

  constructor(private http: HttpClient) { }

  baseUrl: string = environment.apiUrl + '/situacoes';

  public listar(): Observable<SelectItem[]>{
    const url = this.baseUrl 
    return this.http.get<SelectItem[]>(url);
  }
}
