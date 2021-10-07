import { Motivo } from './Motivo';
import { Situacao } from './Situacao';
import {Usuario} from './Usuario';

export class EventoLista {
    id?: any;
    dataEvento: any;
    situacao: Situacao;
    motivo: Motivo;
    usuario: Usuario[];
}
