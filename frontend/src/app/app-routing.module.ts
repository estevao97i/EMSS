import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DiarioErrosComponent } from './components/diario-erros/diario-erros.component';
import { LoginSuccessComponent } from '@nuvem/angular-base';
import {UsuarioReadComponent} from './components/usuario/usuario-read/usuario-read.component';
import {InicioReadComponent} from './components/inicio/inicio-read/inicio-read.component';

const routes: Routes = [
    { path: 'Inicio', component: InicioReadComponent},
    { path: 'Usuario', component: UsuarioReadComponent },
    { path: 'diario-erros', component: DiarioErrosComponent, data: { breadcrumb: 'Diário de Erros'} },
    { path: 'login-success', component: LoginSuccessComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
