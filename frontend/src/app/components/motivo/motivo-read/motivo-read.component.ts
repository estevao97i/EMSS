import { Component, OnInit } from '@angular/core';
import {Motivo} from '../../../models/Motivo';
import { MotivoService } from 'src/app/Service/motivo.service';
import {BlockUiService} from '@nuvem/angular-base';
import {finalize} from 'rxjs/operators';



@Component({
  selector: 'app-motivo-read',
  templateUrl: './motivo-read.component.html',
  styleUrls: ['./motivo-read.component.scss']
})
export class MotivoReadComponent implements OnInit {

    motivo: Motivo[] = [];

    display: Boolean = false;

    showDialog() {
        console.log(this.display);
        this.display = true;
    }

  constructor(private motivoService: MotivoService, private blockUiService: BlockUiService) { }

  ngOnInit(): void {
      this.findAll();
  }

    findAll(): void {
        this.blockUiService.show();
        this.motivoService.listar().pipe(
            finalize(() => this.blockUiService.hide()))
            .subscribe((resposta) => {
          this.motivo = [].concat(resposta);
      });
    }

    // findAll(): void{
    //     this.motivoService.listar().subscribe((res) => {
    //         this.motivo = res;
    //     });
    // }
}
