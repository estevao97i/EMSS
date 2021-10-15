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

  constructor(private usuarioService: UsuarioService, private router: Router) { }

    usuario: Usuario[] = [];

    usuario1: Usuario;

    display: boolean = false;

    displayupdate: boolean = false;

    showDialog() {
        this.display = true;
    }

    showDialogAtualizar(){
      this.atualizar(this.usuario1);
    }

    atualizar(usuario: Usuario) {
        this.usuarioService.findById(usuario.id).subscribe((res) => {
        this.usuario1 = res;
        this.displayupdate = true;
        });
  }

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void {
      this.usuarioService.findAll().subscribe((resposta) => {
          this.usuario = resposta;
      });
    }
  desativarUsuario(usuario: Usuario): void {
    this.usuarioService.inativarUsuario(usuario.id, usuario).subscribe(() => {});
    }

  // encontrarPorId(id: number): void{
  //   this.usuarioService.findById(id).subscribe((res) => {
  //     this.usuario1 = res;
  //   });
  // }

}
