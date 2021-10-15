import { Component, OnInit } from '@angular/core';
import { Motivo } from '../../../models/Motivo';
import { MotivoService } from 'src/app/Service/motivo.service';
import { BlockUiService } from '@nuvem/angular-base';
import { finalize } from 'rxjs/operators';

@Component({
  selector: 'app-motivo-read',
  templateUrl: './motivo-read.component.html',
  styleUrls: ['./motivo-read.component.scss']
})
export class MotivoReadComponent implements OnInit {

  motivo: Motivo[] = [];
  motivo1: Motivo;

  display: Boolean = false;

  displayDelete: boolean = false;

  constructor(private motivoService: MotivoService, private blockUiService: BlockUiService) { }

  ngOnInit(): void {
    this.findAll();
  }

  deleteById(id: number): void{
    this.motivoService.delete(id).subscribe(() => {

    })
  }

  showDialog() {
    this.display = true;
  }

  atualizado(): void {
    this.findAll();
    this.display = false;
  }

  findAll(): void {
    this.blockUiService.show();
    this.motivoService.listar().pipe(
      finalize(() => this.blockUiService.hide()))
      .subscribe((resposta) => {
        this.motivo = [].concat(resposta);
      });
  }
}
