import { UsuarioService } from './../../../Service/usuario.service';
import { MotivoService } from './../../../Service/motivo.service';
import { SituacaoService } from './../../../Service/situacao.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { SelectItem } from 'primeng';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import * as moment from 'moment';
import {EventoService} from '../../../Service/evento.service';


@Component({
  selector: 'app-evento-create',
  templateUrl: './evento-create.component.html',
  styleUrls: ['./evento-create.component.scss']
})

export class EventoCreateComponent implements OnInit {

  @Input() criaEvento: boolean = true;
  @Output() cancelado: EventEmitter<boolean> = new EventEmitter();
  @Output() salvar: EventEmitter<void> = new EventEmitter();
  

  public situacao: SelectItem[] = [];
  public usuario: SelectItem[] = [];
  public motivos: SelectItem[] = [];
  public UsuariosSelecionados: SelectItem[] = [];

  public form: FormGroup;
  public formBuilder: FormBuilder = new FormBuilder;

  constructor( private router: Router,
    private eventoService: EventoService,
    private situacaoService: SituacaoService,
    private motivoService: MotivoService,
    private usuarioService: UsuarioService) { }

  ngOnInit(): void {
    this.buscarSituacao();
    this.buscarMotivo();
    this.buscarUsuarios();
    this.criarFormulario();
    this.UsuariosSelecionados;
  }

  buscarUsuarios(): void {
    this.usuarioService.findAllSelect().subscribe((res) => {
      console.log(res);
      this.usuario = res;
  });
}

  buscarSituacao(): void {
    this.situacaoService.listar().subscribe((res: SelectItem[]) => {
      console.log(res)
      this.situacao = [{
        label: '==Situacao do Evento==',
        value: null
      } as SelectItem].concat(res);

    });
  }

  buscarMotivo(): void {
    this.motivoService.listarSelect().subscribe((res: SelectItem[]) => {
      console.log(res)
      this.motivos = [{
        label: '==Motivo==',
        value: null
      } as SelectItem].concat(res);
    });
  }


public criarFormulario(): void{
  this.form = this.formBuilder.group({
    id: [null],
    dataEvento: ['', Validators.required],
    valor: ['', Validators.required],
    situacao: [null, Validators.required],
    usuario: [null, Validators.required],
    motivo: [null, Validators.required],
  });
}

cancelar(): void {
  this.cancelado.emit(false);
}

formatarMotivo(): void{
  this.form.value.motivo = {value: this.form.value.motivo};
}

formatarData(): void{
  let data: moment.Moment = moment.utc(this.form.value.dataEvento).local();
  this.form.value.dataEvento = data.format('DD/MM/YYYY');
}

formatarSituacao(): void {
  this.form.value.situacao = {value: this.form.value.situacao};
}

create(): void{
  this.formatarMotivo();
  this.formatarSituacao();
  this.eventoService.create(this.form.value).subscribe(() => {
    this.salvar.emit();
  })

  }
}
