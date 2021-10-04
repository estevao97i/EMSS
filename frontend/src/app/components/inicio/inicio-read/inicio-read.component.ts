import { Component, OnInit } from '@angular/core';
import {EventoService} from '../../evento/evento.service';
import {Evento} from '../../../models/Evento';


@Component({
  selector: 'app-inicio-read',
  templateUrl: './inicio-read.component.html',
  styleUrls: ['./inicio-read.component.scss']
})
export class InicioReadComponent implements OnInit {

    evento: Evento[] = [];

    constructor(private eventoService: EventoService) {
    }

    ngOnInit(): void {
        this.findAll();
    }

    findAll(): void {
        this.eventoService.findAll().subscribe((resposta) => {
            this.evento = resposta;
        });

    }
}
