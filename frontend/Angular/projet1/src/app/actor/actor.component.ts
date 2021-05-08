import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-actor',
  templateUrl: './actor.component.html',
  styleUrls: ['./actor.component.css']
})
export class ActorComponent implements OnInit {
@Input() S ;
@Output() delete = new EventEmitter();

 constructor() { }

  ngOnInit(): void {
  }

  supprimer() {
    this.delete.emit(this.S);
  }
}
