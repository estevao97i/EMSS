import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';


@Component({
  selector: 'app-usuario-create',
  templateUrl: './usuario-create.component.html',
  styleUrls: ['./usuario-create.component.css']
})
export class UsuarioCreateComponent implements OnInit {

  constructor( private router: Router) { }

  ngOnInit(): void {
  }

  cancelar(): void{
      this.router.navigate(['/usuario']);
  }

}
