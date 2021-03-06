import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SharedModule } from './shared/shared.module';
import { AppTopbarComponent } from './components/topbar/app.topbar.component';
import { AppFooterComponent } from './components/footer/app.footer.component';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';
import { environment } from '../environments/environment';
import { HttpClientModule } from '@angular/common/http';
import { PageNotificationModule, BreadcrumbModule, MenuModule, ErrorStackModule } from '@nuvem/primeng-components';
import { ErrorModule, SecurityModule, VersionTagModule } from '@nuvem/angular-base';
import { DiarioErrosComponent } from './components/diario-erros/diario-erros.component';
import { BlockUIModule } from 'ng-block-ui';
import { InicioReadComponent } from './components/inicio/evento-read/inicio-read.component';
import {AccordionModule} from 'primeng/accordion';
import {ButtonModule} from 'primeng/button';
import { UsuarioCreateComponent } from './components/usuario/usuario-create/usuario-create.component';
import { UsuarioReadComponent } from './components/usuario/usuario-read/usuario-read.component';
import {InputTextModule} from 'primeng/inputtext';
import {CalendarModule} from 'primeng/calendar';
import {DropdownModule} from 'primeng/dropdown';
import { UsuarioPipe } from './pipe/usuario.pipe';
import { ReactiveFormsModule } from '@angular/forms';
import {DialogModule} from 'primeng/dialog';
import { UsuarioUpdateComponent } from './components/usuario/usuario-update/usuario-update.component';
import { EventoCreateComponent } from './components/inicio/evento-create/evento-create.component';
import { EventoListarComponent } from './components/inicio/evento-listar/evento-listar.component';
import {MultiSelectModule} from 'primeng/multiselect';
import { MotivoReadComponent } from './components/motivo/motivo-read/motivo-read.component';
import { MotivoCreateComponent } from './components/motivo/motivo-create/motivo-create.component';


@NgModule({
    declarations: [
        AppComponent,
        AppTopbarComponent,
        AppFooterComponent,
        DiarioErrosComponent,
        InicioReadComponent,
        UsuarioReadComponent,
        InicioReadComponent,
        UsuarioCreateComponent,
        UsuarioPipe,
        EventoCreateComponent,
        MotivoReadComponent,
        MotivoCreateComponent,
        UsuarioUpdateComponent,
        EventoCreateComponent,
        EventoListarComponent,
        EventoCreateComponent
    ],
    imports: [
        BlockUIModule.forRoot({
            message: "Carregando..."
          }),
        BrowserModule,
        BrowserAnimationsModule,
        AppRoutingModule,
        SharedModule,
        HttpClientModule,
        PageNotificationModule,
        BreadcrumbModule,
        ErrorStackModule,
        ErrorModule,
        VersionTagModule,
        SecurityModule.forRoot(environment.auth),
        MenuModule,
        AccordionModule,
        ButtonModule,
        InputTextModule,
        CalendarModule,
        DropdownModule,
        ReactiveFormsModule,
        DialogModule,
        MultiSelectModule
    ],
    providers: [
        { provide: LocationStrategy, useClass: HashLocationStrategy }
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
