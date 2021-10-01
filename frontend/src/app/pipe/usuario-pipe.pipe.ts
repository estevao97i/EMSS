import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'usuarioPipe'
})
export class UsuarioPipePipe implements PipeTransform {

  transform(ativo: boolean): unknown {
    if (ativo) {
        return 'Ativo';
    } else {
        return 'Inativo';
    }
  }

}
