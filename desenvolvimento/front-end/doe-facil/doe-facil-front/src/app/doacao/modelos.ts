

export class Doacao{
    id:number;
	  nome:string;
    categoria:string;
    img:String;
	  status:string="Disponível";
	  metodoFrete:string;
 	  descricao:string;
    votosPositivos:number=0;
	  votosNegativos:number=0;
    dataInicio:string;
    dataFim:string;
    doador= new Usuario();
    recebedor = new Usuario();
}

export class Usuario{
    idUsuario:number;
    nomeCompleto:string;
    estado:string;
    cidade:string;
    bairro:string;
    rua:string;
    numero:string;
    complemento:string;
    votosPositivosUsuario:number=0;
	  votosNegativosUsuario:number=0;

}
