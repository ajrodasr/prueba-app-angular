import { Component, OnInit } from '@angular/core';
import { IngredientesService } from 'src/app/services/ingredientes.service';

@Component({
  selector: 'app-ingredientes',
  templateUrl: './ingredientes.component.html',
  styleUrls: ['./ingredientes.component.css'],
})
export class IngredientesComponent implements OnInit {
  constructor(private ingredientesService: IngredientesService) {}

  ngOnInit(): void {
    this.ingredientesService
      .getAllIngredientes()
      .subscribe((ingredientes) => console.log(ingredientes));
  }
}
