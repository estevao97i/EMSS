import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { FormGroup } from '@angular/forms';

import {UsuarioService} from '../../../Service/usuario.service';



@Component({
  selector: 'app-usuario-create',
  templateUrl: './usuario-create.component.html',
  styleUrls: ['./usuario-create.component.scss']
})
export class UsuarioCreateComponent implements OnInit {

    // public cargos: SelectedItem[] = [];

    public form: FormGroup;

  constructor(
      private router: Router,
      private usuarioService: UsuarioService,
      ) { }


  ngOnInit(): void {
      // this.criarUsuario();
  }

  // public criarUsuario(): void{
  //     this.form = this.formBilder.group({
  //     });
  // }

  cancelar(): void {
      this.router.navigate(['/usuario']);
  }

}
