import { FormBuilder, FormGroup } from '@angular/forms';
import { EventoLista } from '../../../models/EventoLista';
import { EventoService } from '../../../Service/evento.service';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-evento-listar',
  templateUrl: './evento-listar.component.html',
  styleUrls: ['./evento-listar.component.css']
})
export class EventoListarComponent implements OnInit {

    public formBuilder: FormBuilder = new FormBuilder;
    public form: FormGroup;

  constructor(private eventoService: EventoService) { }

  @Input() leigo: EventoLista;

  ngOnInit(): void {
    this.criarFormulario();
    console.log(this.form);
  }

  public criarFormulario(): void {
    this.form = this.formBuilder.group({
      id: [null],
      dataEvento: [''],
      situacao: [''],
      motivo: [''],
      usuario: ['']
    });
    this.popularFormulario();
  }

  public popularFormulario(): void{
    this.form.get('id').setValue(this.leigo.id);
    this.form.get('dataEvento').setValue(this.leigo.dataEvento);
    this.form.get('situacao').setValue(this.leigo.situacao);
    this.form.get('motivo').setValue(this.leigo.motivo);
    this.form.get('usuario').setValue(this.leigo.usuario);
  }
<<<<<<< HEAD

  public adiarEvento(): void{
    this.eventoService.adiar(this.leigo.id);
  }
} 
=======
}
>>>>>>> dd0394a41e59f4dfc066a590bac1d24573d99c79
