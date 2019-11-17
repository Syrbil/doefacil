import { Doacao } from './doacao/modelos';

export class Usuario{
    idUsuario:number=0;
	  nomeCompleto:string ;
    nomeUsuario:string;
    imgUsuario:Blob;
    email:string;
    senha:string;
    dataNasc:string;
    cpf:string;

    votosPositivosUsuario:number=0;
    votosNegativosUsuario:number=0;

    estado:string;
    cidade:string;
    bairro:string;
    rua:string;
    numero:string;
    complemento:string;

    feitas:Doacao[];
    recebidas:Doacao[];
    notificacoes:Notificacao[];
}

export class Notificacao{
  id:number;
  conteudo:string;
  lida:boolean;

  notificador:Usuario = new Usuario();
  notificado:Usuario = new Usuario();
}


