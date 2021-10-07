import { EventoListarComponent } from './components/inicio/evento-listar/evento-listar.component';
import { UsuarioUpdateComponent } from './components/usuario/usuario-update/usuario-update.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UsuarioReadComponent} from './components/usuario/usuario-read/usuario-read.component';
import {UsuarioCreateComponent} from './components/usuario/usuario-create/usuario-create.component';
import {MotivoReadComponent} from './components/motivo/motivo-read/motivo-read.component';
import { InicioReadComponent } from './components/inicio/evento-read/inicio-read.component';


const routes: Routes = [
    { path: 'inicio', component: InicioReadComponent},
    { path: 'usuario', component: UsuarioReadComponent },
    { path: 'usuario/create', component: UsuarioCreateComponent},
    { path: 'usuario/update', component: UsuarioUpdateComponent},
    { path: 'motivo', component: MotivoReadComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
