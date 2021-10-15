import { SelectItem } from 'primeng';
import { UsuarioService } from './../../../Service/usuario.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit, Input } from '@angular/core';
import { Usuario } from 'src/app/models/Usuario';
import { CargoService } from 'src/app/Service/cargo.service';

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

  cargoSeleciona: SelectItem[] = []

  constructor(private usuarioService: UsuarioService,private cargoService: CargoService) { }

  ngOnInit(): void {
    this.criarFormulario();
    this.buscarCargos();
  }


  public criarFormulario(): void {
    this.form = this.formBuilder.group({
      id: ['', Validators.required],
      nome: ['', Validators.required],
      cpf: ['', Validators.required],
      dataNascimento: ['', Validators.required],
      email: ['', Validators.required],
      status: [true],
      telefone: [''],
      cargo: ['', Validators.required]

    });
    this.popularFormulario();

  }
  public popularFormulario(): void {
    this.form.get('nome').setValue(this.usuarioPronto.nome);
    this.form.get('cpf').setValue(this.usuarioPronto.cpf);
    this.form.get('dataNascimento').setValue(this.usuarioPronto.dataNascimento);
    this.form.get('email').setValue(this.usuarioPronto.email);
    this.form.get('telefone').setValue(this.usuarioPronto.telefone);
    this.form.get('cargo').setValue(this.usuarioPronto.cargo);
    }

    buscarCargos(): void {
      this.cargoService.listar().subscribe((res: SelectItem[]) => {
        this.cargoSeleciona = [{
          label: '==Escolha o Cargo==',
          value: null
        } as SelectItem].concat(res);
      });
    }

  }
