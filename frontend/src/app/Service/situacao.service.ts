import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import {Situacao} from '../models/Situacao';

@Injectable({
  providedIn: 'root'
})
export class SituacaoService {

    baseUrl = 'localhost://8080/api/situacoes';

  constructor(private http: HttpClient) { }

    public listarTodos(): Observable<Situacao[]>{
        return this.http.get<Situacao[]>(this.baseUrl);
    }
}
