import { Component } from '@angular/core';
import { ServicosService } from './servicos.service';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'DOE-FÁCIL';

  constructor(private service: ServicosService,
    public toast: MessageService,){}



}
