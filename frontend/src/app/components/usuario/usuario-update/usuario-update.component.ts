import { UsuarioService } from './../../../Service/usuario.service';
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
  @Input() update: boolean;

  id: string = '';

//   usuario: Usuario = {
//     id: '',
//     nome: '',
//     cpf: '',
//     dataNascimento: '',
//     email: '',
//     status: true,
//     telefone: '',
//     cargo: ''
// }

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit(): void {
    this.criarFormulario();
    this.findById(this.usuarioPronto.id);
  }

  findById(id: any): void{
    this.usuarioService.findById(this.usuarioPronto.id).subscribe(() => {
      // this.usuario = res;
    })
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
    }

  }
