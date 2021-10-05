import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SelectItem } from 'primeng';

@Injectable({
  providedIn: 'root'
})
export class CargoService {

  constructor(private http: HttpClient) { }

  baseUrl = 'http://localhost:8080/api/cargos';

  public listar(): Observable<SelectItem[]>{
    const url = this.baseUrl 
    return this.http.get<SelectItem[]>(url);
  }
}
