import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit, Input } from '@angular/core';
import { Usuario } from 'src/app/models/Usuario';

@Component({
  selector: 'app-usuario-update',
  templateUrl: './usuario-update.component.html',
  styleUrls: ['./usuario-update.component.scss']
})
export class UsuarioUpdateComponent implements OnInit {

  public form: FormGroup;
  public formBuilder: FormBuilder = new FormBuilder;

  @Input() usuarioPronto: Usuario;

  constructor() { }

  ngOnInit(): void {
    this.criarFormulario();
    this.popularFormulario();
  }
  public criarFormulario(): void {
    this.form = this.formBuilder.group({
      id: [null],
      nome: ['', Validators.required],
      cpf: ['', Validators.required],
      dataNascimento: ['', Validators.required],
      email: ['', Validators.required],
      status: [true],
      telefone: [''],
      cargo: ['', Validators.required]

    });
  }
  public popularFormulario(): void {
    this.form.get('id').setValue(this.usuarioPronto.id);
    this.form.get('cpf').setValue(this.usuarioPronto.cpf);
    this.form.get('dataNascimento').setValue(this.usuarioPronto.dataNascimento);
    this.form.get('email').setValue(this.usuarioPronto.email);
    this.form.get('status').setValue(this.usuarioPronto.status);
    this.form.get('telefone').setValue(this.usuarioPronto.telefone);
    this.form.get('cargo').setValue(this.usuarioPronto.cargo);
    this.form.get('nome').setValue(this.usuarioPronto.nome);
    }

  }
