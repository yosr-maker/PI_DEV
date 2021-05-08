import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-convertisseur',
  templateUrl: './convertisseur.component.html',
  styleUrls: ['./convertisseur.component.css']
})
export class ConvertisseurComponent implements OnInit {
  numero ;
  a;
  constructor() {
  }

  ngOnInit(): void {
  }

  convert($event) {
    this.a = (this.numero) * (3.2);
    alert(this.a);
  }

}
