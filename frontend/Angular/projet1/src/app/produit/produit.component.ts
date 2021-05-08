import {Component, OnInit} from '@angular/core';
import {Emploi} from '../Model/Emploi';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css']
})
export class ProduitComponent implements OnInit {
  couleur: string;
  test = true;
  color = 'red';
  products: ({ quantity: number; like: number; price: number; id: number; title: string } | { quantity: number; like: number; price: number; id: number; title: string } | { quantity: number; like: number; price: number; id: number; title: string })[] = [];
ng
  constructor() {
  }

  ngOnInit(): void {
    this.products = [
      {id: 1, title: 'T-shirt 1', price: 18, quantity: 0, like: 0},
      {id: 2, title: 'T-shirt 2', price: 21, quantity: 10, like: 0},
      {id: 3, title: 'T-shirt 3', price: 16, quantity: 8, like: 0},
    ];
  }

showmsg() {
    alert('hfljf');
  }

  addlike(i) {
    this.products[i].like++;
  }

  getcolor(test) {
    console.log(test);
    return this.couleur = test;
  }
}

