import { Component, Input, ModuleWithComponentFactories, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {UsuarioService} from '../../../Service/usuario.service';
import { SelectItem } from 'primeng';
import { CargoService } from 'src/app/Service/cargo.service';



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
  }

  public criarFormulario(): void{
      this.form = this.formBuilder.group({
        id: [null],
        nome: ['', Validators.required],
        cpf: ['', Validators.required],
        dataNascimento: ['', Validators.required],
        email: ['', Validators.required],
        status: [''],
        telefone: [''],
        cargo: [null, Validators.required]
      });
  }

  cancelar(): void {
      this.router.navigate(['/usuario']);
  }

  buscarCargos(): void{
    this.cargoService.listar().subscribe((res: SelectItem[]) => {
      this.cargos = [{
        label: '==Escolha o Cargo==',
        value: null
      } as SelectItem].concat(res);
    })
  }

  create(): void{
    this.usuarioService.create(this.form.getRawValue());
  }

  // formatarData(): void{
  //   let data: moment.Moment = moment.utc
  // }

}
