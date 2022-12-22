import { Injectable  } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable, of } from 'rxjs';
import { Recipe } from '../../models/recipe.model';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  apiUrl: string = 'http://localhost:8080/api/v1';

  constructor(private httpClient: HttpClient) { }

  getRecipes(): Observable<Recipe[]> {
    return this.httpClient.get<Recipe[]>(`${this.apiUrl}/recipe`);
  }
}
