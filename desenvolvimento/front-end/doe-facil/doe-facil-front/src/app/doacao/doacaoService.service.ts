import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Doacao, Usuario } from './modelos';


@Injectable({
  providedIn: 'root'
})
export class doacaoService {

  doacaoURL = 'http://localhost:8090/doacoes';
  usuarioURL = 'http://localhost:8090/usuarios'

  constructor( private http: HttpClient) { }

  pesquisarDoacoes(): Promise<any> {
    return this.http.get<any>(this.doacaoURL).toPromise();
  }

  excluirDoacao(id:number):Promise<void>{
    return this.http.delete(this.doacaoURL+'/'+id)
    .toPromise()
    .then(() => null);
  }

  adicionarDoacao(doacao: Doacao): Promise<any>{
    return this.http.post(this.doacaoURL, doacao)
    .toPromise();
  }

  alterar(doacao: Doacao): Promise<any>{
    return this.http.put(this.doacaoURL+'/'+doacao.id, doacao)
    .toPromise();
  }

  buscarPorCodigo(codigo: number): Promise<Doacao> {
    return this.http.get<Doacao>(this.doacaoURL+'/'+codigo).toPromise();
  }

  atualizarUsuario(usuario: Usuario): Promise<any>{
    return this.http.put(this.usuarioURL+'/'+usuario.idUsuario, usuario)
    .toPromise();
  }



}
