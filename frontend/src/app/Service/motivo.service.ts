import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Motivo} from '../models/Motivo';
import {Situacao} from '../models/Situacao';

@Injectable({
  providedIn: 'root'
})
export class MotivoService {

    baseUrl = 'http://localhost:8080/api/motivos';

  constructor(private http: HttpClient) { }

    public listarTodos(): Observable<Motivo[]>{
      return this.http.get<Motivo[]>(this.baseUrl);
    }
}
