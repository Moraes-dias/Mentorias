import { Routes } from '@angular/router';
import { CarroComponentComponent } from './components/carro-component/carro-component.component';
export const routes: Routes = [
  {
    path: '',
    redirectTo: 'carro',
    pathMatch: 'full'
  },
  {
    path: 'carro',
    component: CarroComponentComponent
  }
];//comen
