import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ProductService} from '../product/product.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  product;

  constructor(private router: ActivatedRoute, private s: ProductService) {
  }

  ngOnInit(): void {
    this.s.getSingleProduct(this.router.snapshot.params.id).subscribe(
      (res) => {
        this.product = res;
      },
      error => {alert('msg');}
    );
    //alert(this.router.snapshot.params.id);
  }

}
