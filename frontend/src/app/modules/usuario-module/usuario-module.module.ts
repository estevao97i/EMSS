import { UsuarioReadComponent } from './../../components/usuario/usuario-read/usuario-read.component';
import { InicioReadComponent } from './../../components/inicio/inicio-read/inicio-read.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
    {path: '', component: UsuarioReadComponent},
    {path: ''}
] 

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forChild(routes)
  ]
})
export class UsuarioModuleModule { }
