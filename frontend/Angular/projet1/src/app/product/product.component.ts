import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  @Input() P;
  @Output() test = new EventEmitter();
  @Output() decrease = new EventEmitter();

  constructor() {
  }

  ngOnInit(): void {
  }

  increment() {
this.test.emit(this.P);
  }
  decrement() {
    this.decrease.emit(this.P);
  }
}
