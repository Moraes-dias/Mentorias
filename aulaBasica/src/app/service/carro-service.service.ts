import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Carro } from '../model/carro';

@Injectable({
  providedIn: 'root'
})
export class CarroServiceService {

  private apiUrl = 'http://localhost:8080/api/carros'; // Ajustado para /api/carros

  constructor(private http: HttpClient) { }

  listar(): Observable<Carro[]> {
    return this.http.get<Carro[]>(this.apiUrl);
  }

  salvar(carro: Carro): Observable<Carro> {
    // Se tiver ID, atualiza (PUT), senão cria (POST)
    if (carro.id) {
      return this.http.put<Carro>(`${this.apiUrl}/${carro.id}`, carro);
    } else {
      return this.http.post<Carro>(this.apiUrl, carro);
    }
  }

  deletar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
//comenta
