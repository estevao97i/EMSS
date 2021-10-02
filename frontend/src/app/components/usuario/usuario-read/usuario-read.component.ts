import { Component, OnInit } from '@angular/core';
import {  Router} from '@angular/router';
import { Usuario } from 'src/app/models/Usuario';
import {UsuarioService} from '../usuario.service';

@Component({
  selector: 'app-usuario-read',
  templateUrl: './usuario-read.component.html',
  styleUrls: ['./usuario-read.component.scss']
})
export class UsuarioReadComponent implements OnInit {

    usuario: Usuario[] = [];


  constructor(private usuarioService: UsuarioService, private router: Router) { }

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void {
      this.usuarioService.findAll().subscribe((resposta) => {
          this.usuario = resposta;
      });

      
  }
  usuarioCreate(): void {
      this.router.navigate(['/usuario/create']);
  }

}
