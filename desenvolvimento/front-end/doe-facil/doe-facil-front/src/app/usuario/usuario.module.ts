import { DropdownModule } from 'primeng/dropdown';
import { PanelModule } from 'primeng/panel';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule} from '@angular/router';
import {InputTextModule} from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {TooltipModule} from 'primeng/tooltip';
import { FormsModule } from '@angular/forms';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import { DataViewModule } from 'primeng/dataview';
import { ToastModule } from 'primeng/toast';
import {PasswordModule} from 'primeng/password';
import {DialogModule} from 'primeng/dialog';
import {FileUploadModule} from 'primeng/fileupload';
import {InputMaskModule} from 'primeng/inputmask';
import {CheckboxModule} from 'primeng/checkbox';
import {DynamicDialogModule} from 'primeng/dynamicdialog';
import { TableModule } from 'primeng/table';
import { MessageService } from 'primeng/api';

import { UsuarioCadastroComponent } from './usuario-cadastro/usuario-cadastro.component';
import { ServicosService } from '../servicos.service';
import { MeuPerfilComponent } from './meu-perfil/meu-perfil.component';
import { OutremPerfilComponent } from './outrem-perfil/outrem-perfil.component';
import { InputTextareaModule } from 'primeng/inputtextarea';

@NgModule({
  declarations: [UsuarioCadastroComponent, MeuPerfilComponent, OutremPerfilComponent],
  imports: [
    CommonModule,
    DataViewModule,
    InputTextModule,
    ButtonModule,
    TooltipModule,
    ToastModule,
    FormsModule,
    ConfirmDialogModule,
    RouterModule,
    PanelModule,
    DropdownModule,
    InputTextModule,
    PasswordModule,
    DialogModule,
    FileUploadModule,
    InputMaskModule,
    TableModule,
    CheckboxModule,
    DynamicDialogModule,
    InputTextareaModule,
  ],
  providers: [
    ServicosService,
    MessageService
  ],
  exports:[
    UsuarioCadastroComponent
  ]
})
export class UsuarioModule { }
