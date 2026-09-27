import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms';
import { MdbRippleModule } from 'mdb-angular-ui-kit/ripple';
import { Carro } from '../../model/carro';
import { CarroServiceService } from '../../service/carro-service.service';

@Component({
  selector: 'app-carro-component',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MdbFormsModule,
    MdbRippleModule
  ],
  templateUrl: './carro-component.component.html',
  styleUrls: ['./carro-component.component.scss']
})
export class CarroComponentComponent implements OnInit {

  carros: Carro[] = [];
  carro: Carro = { modelo: '', marca: '', ano: 0, cor: '' };

  constructor(private carroService: CarroServiceService) { }

  ngOnInit(): void {
    this.carregarCarros();
  }

  carregarCarros(): void {
    this.carroService.listar().subscribe({
      next: (dados) => this.carros = dados,
      error: (err) => console.error('Erro ao carregar carros', err)
    });
  }

  salvar(): void {
    this.carroService.salvar(this.carro).subscribe({
      next: () => {
        this.carregarCarros();
        this.limparFormulario();
      },
      error: (err) => console.error('Erro ao salvar carro', err)
    });
  }

  editar(c: Carro): void {
    this.carro = { ...c };
  }

  deletar(id?: number): void {
    if (id && confirm('Deseja realmente excluir este carro?')) {
      this.carroService.deletar(id).subscribe({
        next: () => this.carregarCarros(),
        error: (err) => console.error('Erro ao deletar carro', err)
      });
    }
  }

  limparFormulario(): void {
    this.carro = { modelo: '', marca: '', ano: 0, cor: '' };
  }
}
