import { Observable } from 'rxjs';
import { SelectItem } from 'primeng';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Motivo} from '../models/Motivo';

@Injectable({
  providedIn: 'root'
})
export class MotivoService {

    baseUrl = 'http://localhost:8080/api/motivos';

  constructor(private http: HttpClient) { }

  public listarSelect(): Observable<SelectItem[]> {
      const url = `${this.baseUrl}/select`;
    return this.http.get<SelectItem[]>(url);
  }

    public listar(): Observable<Motivo[]> {
        const url = this.baseUrl;
        return this.http.get<Motivo[]>(url);
    }

  public create(motivo: Motivo): Observable <Motivo> {
      const url = this.baseUrl;
    return this.http.post<Motivo>(url,motivo);
  }

  public delete(id: number): Observable<void> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.delete<void>(url);
  }
}


