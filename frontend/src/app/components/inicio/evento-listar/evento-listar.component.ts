import { FormBuilder, FormGroup } from '@angular/forms';
import { EventoLista } from '../../../models/EventoLista';
import { EventoService } from '../../../Service/evento.service';
import { Component, Input, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-evento-listar',
  templateUrl: './evento-listar.component.html',
  styleUrls: ['./evento-listar.component.css']
})
export class EventoListarComponent implements OnInit {

    public formBuilder: FormBuilder = new FormBuilder;
    public form: FormGroup;

  constructor(private eventoService: EventoService, private router: Router) { }

  @Input() leigo: EventoLista;

  ngOnInit(): void {}


  public adiarEvento(): void{
    this.eventoService.adiar(this.leigo.id).subscribe((res) => {
        this.router.navigate(['/inicio']);
    });
  }
}
