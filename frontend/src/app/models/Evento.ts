import { Situacao } from "./Situacao";
import { Usuario } from "./Usuario";
import { Motivo } from "./Motivo";

export class Evento{
    id?: number;
    dataEvento: any;
    justificativaAdiamento?: string;
    valor: number;
    situacao: Situacao;
    motivo: Motivo; 
    usuario: Usuario[];
}