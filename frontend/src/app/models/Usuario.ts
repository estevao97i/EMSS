import { SelectItem } from 'primeng';
import { Cargo } from './Cargo';
import { Select } from './Select';

export class Usuario {
    id?: any;
    nome: string;
    cpf: string;
    dataNascimento: any;
    email: string;
    status: boolean;
    foto?: any[];
    telefone: string;
    cargo: Select;
}
