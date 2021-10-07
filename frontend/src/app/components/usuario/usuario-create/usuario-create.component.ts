import { Component, Input, ModuleWithComponentFactories, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {UsuarioService} from '../../../Service/usuario.service';
import { SelectItem } from 'primeng';
import { CargoService } from 'src/app/Service/cargo.service';
import * as moment from 'moment';



@Component({
  selector: 'app-usuario-create',
  templateUrl: './usuario-create.component.html',
  styleUrls: ['./usuario-create.component.scss']
})
export class UsuarioCreateComponent implements OnInit {

    @Input() criaUsuario: boolean = true;

    public cargos: SelectItem[] = [];

    public form: FormGroup;
    public formBuilder: FormBuilder = new FormBuilder;


  constructor(
      private router: Router,
      private usuarioService: UsuarioService,
      private cargoService: CargoService
      ) { }

  ngOnInit(): void {
      this.criarFormulario();
      this.buscarCargos();
  }

  public criarFormulario(): void{
    this.form = this.formBuilder.group({
      id: [null],
      nome: ['', Validators.required],
      cpf: ['', Validators.required],
      dataNascimento: ['', Validators.required],
      email: ['', Validators.required],
      status: [true],
      telefone: [''],
      cargo: [null, Validators.required]
    });
}

  cancelar(): void {
      this.router.navigate(['/usuario']);
  }

  buscarCargos(): void {
    this.cargoService.listar().subscribe((res: SelectItem[]) => {
      this.cargos = [{
        label: '==Escolha o Cargo==',
        value: null
      } as SelectItem].concat(res);
    });
  }

  create(): void {
    this.formatarData();
    this.formatarCargo();
    this.usuarioService.create(this.form.getRawValue()).subscribe(() => {
      this.router.navigate(['/usuario']);
    });
  }

  formatarCargo(): void{
    this.form.value.cargo = {value: this.form.value.cargo};
  }

  formatarData(): void{
    let data: moment.Moment = moment.utc(this.form.value.dataNascimento).local();
    this.form.value.dataNascimento = data.format('DD/MM/YYYY')
  }
}
