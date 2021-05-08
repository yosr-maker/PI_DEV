import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-actors',
  templateUrl: './actors.component.html',
  styleUrls: ['./actors.component.css']
})
export class ActorsComponent implements OnInit {
  listActors;

  constructor() {
  }

  ngOnInit(): void {
    this.listActors = [
      {lastName: 'Robert', firstName: 'Julia'},
      {lastName: 'Walker', firstName: 'Paul'},
      {lastName: 'Pitt', firstName: 'Brad'},
    ];
  }

  supprimer($event) {
  let i = this.listActors.indexOf($event);
      this.listActors.splice(i,1);
    }

}


