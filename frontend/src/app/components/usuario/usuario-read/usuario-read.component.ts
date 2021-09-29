import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/models/Usuario';

@Component({
  selector: 'app-usuario-read',
  templateUrl: './usuario-read.component.html',
  styleUrls: ['./usuario-read.component.css']
})
export class UsuarioReadComponent implements OnInit {

    usuario: any[] = [];
    //
    // usuario: Usuario[] = [];



  constructor() { }

  ngOnInit(): void {
  //     this.customerService.getCustomersLarge().then(customers => {
  //     this.customers = customers;
  //     this.loading = false;
  // });

  //     this.usuario = [
  //         {name: "Amy Elsner", image: 'amyelsner.png'},
  //         {name: "Anna Fali", image: 'annafali.png'},
  //         {name: "Asiya Javayant", image: 'asiyajavayant.png'},
  //         {name: "Bernardo Dominic", image: 'bernardodominic.png'},
  //         {name: "Elwin Sharvill", image: 'elwinsharvill.png'},
  //         {name: "Ioni Bowcher", image: 'ionibowcher.png'},
  //         {name: "Ivan Magalhaes",image: 'ivanmagalhaes.png'},
  //         {name: "Onyama Limba", image: 'onyamalimba.png'},
  //         {name: "Stephen Shaw", image: 'stephenshaw.png'},
  //         {name: "XuXue Feng", image: 'xuxuefeng.png'}
  //     ];
  }

}
