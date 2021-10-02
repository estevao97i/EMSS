import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'usuario'
})
export class UsuarioPipe implements PipeTransform {

  transform(ativo: boolean): unknown {
    if(ativo){
        return 'Ativo';
    } else {
        return 'Inativo';
    }
  }

}
