import { SelectItem } from 'primeng';
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from 'src/app/models/Usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

    baseUrl = 'http://localhost:8080/api/usuario';

  constructor(private http: HttpClient) { }

    public findAll(): Observable<Usuario[]> {
      return this.http.get<Usuario[]>(this.baseUrl);
    }

    public findAllSelect(): Observable<SelectItem[]> {
      return this.http.get<SelectItem[]>(this.baseUrl + `/select`);
    }

    public findById(id: number): Observable<Usuario> {
      const url = this.baseUrl + `/${id}`;
      return this.http.get<Usuario>(url);
    }

    public create(usuario: Usuario): Observable<Usuario> {
      const url = this.baseUrl;
      // usuario.cargo = {value: usuario.cargo}
      return this.http.post<Usuario>(url,usuario);
    }

    public update(usuario: Usuario): Observable<Usuario> {
      const url = this.baseUrl + `/${usuario.id}`;
      console.log(usuario);
      return this.http.put<Usuario>(url, usuario);
    }

    public inativarUsuario(id: number, usuario: Usuario): Observable<Usuario>{
      const url = this.baseUrl + `/desativa/${id}`;
      return this.http.put<Usuario>(url, usuario);

    }
}
