import { UsuarioUpdateComponent } from './components/usuario/usuario-update/usuario-update.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DiarioErrosComponent } from './components/diario-erros/diario-erros.component';
import { LoginSuccessComponent } from '@nuvem/angular-base';
import {UsuarioReadComponent} from './components/usuario/usuario-read/usuario-read.component';
import {InicioReadComponent} from './components/inicio/inicio-read/inicio-read.component';
import {UsuarioCreateComponent} from './components/usuario/usuario-create/usuario-create.component';


const routes: Routes = [
    { path: 'inicio', component: InicioReadComponent},
    { path: 'usuario', component: UsuarioReadComponent },
    { path: 'usuario/create', component: UsuarioCreateComponent},
    { path: 'usuario/update', component: UsuarioUpdateComponent},
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
