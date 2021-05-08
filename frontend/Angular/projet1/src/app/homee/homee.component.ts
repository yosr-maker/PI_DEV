import {Component, OnInit} from '@angular/core';
import {ProductService} from '../product/product.service';

@Component({
  selector: 'app-homee',
  templateUrl: './homee.component.html',
  styleUrls: ['./homee.component.css']
})
export class HomeeComponent implements OnInit {
  listproduct: any[];
  show = false;
  j = -1;

  constructor(private s: ProductService) {
  }

  ngOnInit(): void {
    this.s.getProduct().subscribe(
      (result) => {
        this.listproduct = result;
        console.log(this.listproduct);
      }
    );
  }

  showDescription(i) {
    this.j = i;
    this.show = true;
  }
}
