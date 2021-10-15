import { EventoLista } from './../../../models/EventoLista';
import { Component, OnInit } from '@angular/core';
import { EventoService } from '../../../Service/evento.service';
import { Evento } from '../../../models/Evento';
import { BlockUiService } from '@nuvem/angular-base';

import { finalize } from 'rxjs/operators';


@Component({
    selector: 'app-inicio-read',
    templateUrl: './inicio-read.component.html',
    styleUrls: ['./inicio-read.component.scss']
})
export class InicioReadComponent implements OnInit {

    evento: Evento[] = [];

    evento1: EventoLista;

    displayEvento: boolean = false;
    display: boolean = false;

    showDialogListaEvento(id: number) {
        this.encontrarPorId(id);
        this.displayEvento = true;
    }

    showDialog() {
        this.display = true;
    }

    constructor(private eventoService: EventoService, private blockUiService: BlockUiService) {
    }

    ngOnInit(): void {
        this.findAll();
        // this.encontrarPorId(evento1.id);
    }
    atualizar(): void {
        this.findAll();
        this.display = false;
        console.log('funfou');
    }

    atualizarData():void{
        this.findAll();
        this.displayEvento = false;
    }


    findAll(): void {
        this.blockUiService.show();
        this.eventoService.findAll()
            .pipe(
                finalize(() => this.blockUiService.hide()))
            .subscribe((resposta) => {
                this.evento = resposta;
            });

    }

    encontrarPorId(id: number): void {
        this.eventoService.findById(id).subscribe((res) => {
            this.evento1 = res;
        });
    }

    // desativarUsuario(usuario: Usuario): void{
    //     this.usuarioService.inativarUsuario(usuario.id, usuario).subscribe(() => {})
    //   }
}
