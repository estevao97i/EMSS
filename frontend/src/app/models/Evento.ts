import { Situacao } from "./Situacao";
import { Usuario } from "./Usuario";
import { Motivo } from "./Motivo";
import { Select } from "./Select";

export class Evento{
    id?: number;
    dataEvento: Date;
    justificativaAdiamento?: string;
    valor: number;
    situacao: Select;
    motivo: Select;
    usuario: Select[];
}
