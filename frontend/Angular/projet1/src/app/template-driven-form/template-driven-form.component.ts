import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-template-driven-form',
  templateUrl: './template-driven-form.component.html',
  styleUrls: ['./template-driven-form.component.css']
})
export class TemplateDrivenFormComponent implements OnInit {
  info = [];

  constructor() {
  }

  ngOnInit(): void {
  }

  ajouter(form) {
    this.info.push(form);
    console.log(this.info);
    console.log(form);
  }
}
