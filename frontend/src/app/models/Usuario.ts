import { Cargo } from "./Cargo";

export class Usuario{
    id?: number;
    nome: string;
    cpf: string;
    dataNascimento: any;
    email: string;
    status: boolean;
    foto?: any[];
    telefone: string;
    cargo: Cargo;
}