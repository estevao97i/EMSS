import {Component, Input, OnInit} from '@angular/core';
import {FormGroup, FormBuilder} from '@angular/forms';
import {Router} from '@angular/router';
import {UsuarioService} from '../../../Service/usuario.service';
import {SituacaoService} from '../../../Service/situacao.service';
import { MotivoService } from 'src/app/Service/motivo.service';
import {SelectItem} from 'primeng';

@Component({
  selector: 'app-evento-create',
  templateUrl: './evento-create.component.html',
  styleUrls: ['./evento-create.component.scss']
})
export class EventoCreateComponent implements OnInit {

    @Input() criaEvento: boolean = true;

    public usuarios: SelectItem[] = [];

    public form: FormGroup;
    public formBuilder: FormBuilder;


    constructor(private router: Router, private usuarioService: UsuarioService, private situacaoService: SituacaoService,private motivoService: MotivoService) { }

  ngOnInit(): void {

  }

}
