import { Component, OnInit } from '@angular/core';
import { doacaoService } from '../doacaoService.service';
import { Doacao } from '../modelos';
import { SelectItem, MessageService, MenuItem, ConfirmationService } from 'primeng/api';
import { ServicosService } from 'src/app/servicos.service';
import { Usuario, Notificacao } from 'src/app/model';
import { Router } from '@angular/router';


@Component({
  selector: 'app-doacao-pesquisa',
  templateUrl: './doacao-pesquisa.component.html',
  styleUrls: ['./doacao-pesquisa.component.css']
})
export class DoacaoPesquisaComponent implements OnInit{

  notificacoes:Notificacao[];
  doacoes : Doacao[];
  ordem : SelectItem[];
  sortOrder: number;
  sortField:String;
  displayDialog: boolean = false;
  mostrarNotificacoes: boolean = false;

  nomeUsuario:string;
  senha:string;
  logado:Usuario=null;

  items: MenuItem[];


  constructor(  private service: doacaoService,
    private messageService: MessageService,
    private service2:ServicosService,
    private rotaprogramatica:Router,
    private conf: ConfirmationService,) { }

  ngOnInit() {
      this.service.pesquisarDoacoes() .then((dados)=>{   this.doacoes=dados  });

      this.logado = this.service2.Usuariologado();

      this.ordem = [
        {label: 'Categoria ', value: 'categoria'},
        {label: 'Nome', value: 'nome'},
        {label: 'Estado', value: 'doador.estado'}
    ];

    this.items = [{
      label: this.logado.nomeCompleto,
      items: [
          {label: 'Meu Perfil', icon: 'pi pi-user' ,routerLink:"/usuario/meuperfil"},
          {label: 'Notificações', icon: 'pi pi-bell', command: () => {this.abrirNotificacoes()} },
          {label: 'Sair', icon: 'pi pi-sign-out' , command: () => {this.logoff()}}
      ]
    }];

}

onSortChange(event) {
  let value = event.value;
      this.sortOrder = 1;
      this.sortField= value;
}

showDialog() {
    this.displayDialog = true;
}

login(){
  this.service2.autenticar(this.nomeUsuario,this.senha);
  this.logado=this.service2.Usuariologado();
}

logoff(){
  window.location.reload();
}

abrirNotificacoes(){
  this.service2.buscarNotificacoes(this.logado.idUsuario).then((dados)=>{this.notificacoes=dados}).then(()=>{
    this.mostrarNotificacoes = true;
  });

}

confirmarExclusao(notificacao:Notificacao){
  this.conf.confirm({
    message: 'Tem certeza que deseja excluir a Notificação?',
    accept: () => {
      this.excluir(notificacao);
    }
  });
}

excluir(notificacao:Notificacao){
  this.service2.excluirNotificacao(notificacao.id)
  .then(()=>{
    this.service2.buscarNotificacoes(this.logado.idUsuario).then((dados)=>{this.notificacoes=dados})
    .then(()=>{
     this.messageService.add({severity:'success', summary:'Notificação excluída'});
    });

  });
}


}
