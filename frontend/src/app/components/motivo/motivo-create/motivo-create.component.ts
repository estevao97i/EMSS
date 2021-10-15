import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MotivoService } from 'src/app/Service/motivo.service';

@Component({
      selector: 'app-motivo-create',
      templateUrl: './motivo-create.component.html',
      styleUrls: ['./motivo-create.component.scss']
})
export class MotivoCreateComponent implements OnInit {

      @Output() atualizar: EventEmitter<void> = new EventEmitter();
      @Output() cancelado: EventEmitter<void> = new EventEmitter();

      public form: FormGroup;
      public formBuilder: FormBuilder = new FormBuilder;


      constructor(private router: Router, private motivoService: MotivoService) { }

      ngOnInit(): void {
            this.criarMotivo();
      }

      public criarMotivo(): void {
            this.form = this.formBuilder.group({
                  id: [null],
                  titulo: ['', Validators.required],
                  descricao: ['', Validators.required]
            });
      }

      create(): void {
            this.motivoService.create(this.form.getRawValue()).subscribe((resposta) => {
                  this.atualizar.emit();
            }
            );

      }
      cancelar(): void{
            this.cancelado.emit();
      }

}
