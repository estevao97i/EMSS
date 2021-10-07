import { Usuario } from './../components/usuario/usuario';
import { Motivo } from './Motivo';
import { Situacao } from './Situacao';

export class EventoLista {
    id?: any;
    dataEvento: any;
    situacao: Situacao;
    motivo: Motivo;
    usuario: Usuario[];
}