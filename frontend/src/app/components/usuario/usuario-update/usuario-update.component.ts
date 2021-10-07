import { FormGroup } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-usuario-update',
  templateUrl: './usuario-update.component.html',
  styleUrls: ['./usuario-update.component.scss']
})
export class UsuarioUpdateComponent implements OnInit {

  public form: FormGroup;

  constructor() { }

  ngOnInit(): void {
  }

  // public criarFormulario(): void{
  //   this.form = this.formBuilder.group({
  //     id: [null],
  //     nome: ['', Validators.required],
  //     cpf: ['', Validators.required],
  //     dataNascimento: ['', Validators.required],
  //     email: ['', Validators.required],
  //     status: [true],
  //     telefone: [''],
  //     cargo: [null, Validators.required]
  //   });
  // }
}
