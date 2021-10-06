
import { SelectItem } from 'primeng';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MotivoService {


    baseUrl = 'http://localhost:8080/api/motivos';

  constructor(private http: HttpClient) { }

  public listar(): Observable<SelectItem[]> {
    const url = this.baseUrl;
    return this.http.get<SelectItem[]>(url);
  }
}

