import { EventoLista } from './../models/EventoLista';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Evento } from 'src/app/models/Evento';

@Injectable({
  providedIn: 'root'
})
export class EventoService {

    baseUrl = "http://localhost:8080/api/eventos";

  constructor( private http: HttpClient) { }

    findAll(): Observable<Evento[]> {
      return this.http.get<Evento[]>(this.baseUrl);
    }

    findById(id: number): Observable<EventoLista> {
      const url = `${this.baseUrl}/${id}`;
      return this.http.get<EventoLista>(url);
    }

    create(evento: Evento): Observable<Evento> {
      const url = `${this.baseUrl}`;
      return this.http.post<Evento>(url, evento);
    }

    update(id: number, evento: Evento): Observable<Evento> {
      const url = `${this.baseUrl}/` + `{id}`;
      return this.http.put<Evento>(url, evento);
    }

    delete(id: number): Observable<void> {
      const url = `${this.baseUrl}/` + `{id}`;
      return this.http.delete<void>(url);
    }

    adiar(id: number): Observable<void> {
      const url = `${this.baseUrl}/` + `{id}`;
      return this.http.put<void>(url, null);
    }

  }