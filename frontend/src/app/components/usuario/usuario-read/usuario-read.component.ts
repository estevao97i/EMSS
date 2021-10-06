import { UsuarioService } from './../../../Service/usuario.service';
import { Component, OnInit } from '@angular/core';
import {  Router} from '@angular/router';
import { Usuario } from 'src/app/models/Usuario';


@Component({
  selector: 'app-usuario-read',
  templateUrl: './usuario-read.component.html',
  styleUrls: ['./usuario-read.component.scss']
})
export class UsuarioReadComponent implements OnInit {

    usuario: Usuario[] = [];

    display: boolean = false;

    showDialog() {
        this.display = true;
    }


  constructor(private usuarioService: UsuarioService, private router: Router) { }

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void {
      this.usuarioService.findAll().subscribe((resposta) => {
          this.usuario = resposta;
      });
    }

  desativarUsuario(usuario: Usuario): void{
    this.usuarioService.inativarUsuario(usuario.id, usuario).subscribe(() => {})
  }  

}
