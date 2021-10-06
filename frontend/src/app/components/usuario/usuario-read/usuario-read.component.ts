import { Component, OnInit } from '@angular/core';
import {  Router} from '@angular/router';
import { Usuario } from 'src/app/models/Usuario';
import {UsuarioService} from '../../../Service/usuario.service';


@Component({
  selector: 'app-usuario-read',
  templateUrl: './usuario-read.component.html',
  styleUrls: ['./usuario-read.component.scss']
})
export class UsuarioReadComponent implements OnInit {

  constructor(private usuarioService: UsuarioService, private router: Router) { }

    usuario: Usuario[] = [];

    display: boolean = false;

    update: Boolean = false;

    showDialog() {
        this.display = true;
    }

    atualizar() {
        this.update = true;
    }

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void {
      this.usuarioService.findAll().subscribe((resposta) => {
          this.usuario = resposta;
      });


  }

}
