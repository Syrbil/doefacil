
import { Component, OnInit } from '@angular/core';
import { MessageService, ConfirmationService } from 'primeng/api';
import { FormControl } from '@angular/forms';
import { doacaoService } from '../doacaoService.service';
import { Doacao} from '../modelos';
import { Router, ActivatedRoute } from '@angular/router';
import { ServicosService } from 'src/app/servicos.service';
import { Usuario } from 'src/app/model';


@Component({
  selector: 'app-doacao-cadastro',
  templateUrl: './doacao-cadastro.component.html',
  styleUrls: ['./doacao-cadastro.component.css']
})
export class DoacaoCadastroComponent implements OnInit {

nova:Doacao=new Doacao();
logado:Usuario;
data = new Date();

categorias=[
  {label:'Vestimenta', value:'Vestimenta'},
  {label:'Eletrônicos', value:'Eletrônicos'},
  {label:'Brinquedos', value:'Brinquedos'},
  {label:'Livros', value:'Livros'},
  {label:'Ferramentas', value:'Ferramentas'},
  {label:'Outros', value:'Outros'},
];

metodos=[
  {label:'Doador Paga o Frete', value:'Doador Paga o Frete'},
  {label:'Recebedor Paga o Frete', value:'Recebedor Paga o Frete'},
  {label:'A Combinar', value:'A Combinar'},
];


  constructor(private service: doacaoService,
    private messageService: MessageService,
    private rotaprogramatica:Router,
    private rota: ActivatedRoute,
    private service2:ServicosService,
    private conf: ConfirmationService,) { }

ngOnInit() {

    if(this.service2.logado==null){
    this.rotaprogramatica.navigate(['/doacoes'])
    }else{
    this.logado = this.service2.Usuariologado();
    const codigoDoacao = this.rota.snapshot.params['id'];
    if(codigoDoacao){ this.carregarDoacao(codigoDoacao); }
    }

  }

  cadastrar(form: FormControl) {

    this.nova.doador.idUsuario=this.logado.idUsuario;
    this.nova.dataInicio=this.data.toLocaleDateString("pt-PT" ,{
      year: "numeric",
      month: "2-digit",
      day: "numeric"
  })

    this.service.adicionarDoacao(this.nova)
      .then(() => {
        this.messageService.add({ severity: 'success', detail: 'Doação ' + this.nova.nome + ' Cadastrada' });
        form.reset();
      }).then( ()=>{
        this.rotaprogramatica.navigate(['/doacoes']);
      });

  }


  carregarDoacao(id:number){
    this.service.buscarPorCodigo(id).then((data) => { this.nova = data}).then(()=>{
      if(this.nova.doador.idUsuario!=this.service2.logado.idUsuario){
        this.rotaprogramatica.navigate(['/doacoes']);
      }
    })
  }

  alterar(form: FormControl) {
    this.service.alterar(this.nova)
    .then( ()=>{
      this.messageService.add({severity:'success', summary:'Edição', detail:'Doacão '+this.nova.nome+' alterada'});
      form.reset();
    }).then( ()=>{
      this.rotaprogramatica.navigate(['/usuario/meuperfil']);
    })

  }

  salvar(form: FormControl) {
    if(this.editando){
      this.alterar(form);
    }else{
      this.cadastrar(form);
    }
  }


  get editando(){
    return Boolean(this.nova.id);
  }


}
