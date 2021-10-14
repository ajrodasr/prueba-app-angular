import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ingrediente } from '../models/ingrediente.interface';

@Injectable({
  providedIn: 'root',
})
export class IngredientesService {
  constructor(private http: HttpClient) {}

  getAllIngredientes(): Observable<Ingrediente[]> {
    return this.http.get<Ingrediente[]>('/api/getIngredientes');
  }
}

//ng serve --proxy-config proxy.conf.json
