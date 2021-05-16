
import { Component, OnInit} from '@angular/core';
import { NgbCarousel, NgbCarouselConfig, NgbSlideEvent, NgbSlideEventSource } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css'],
  providers: [NgbCarouselConfig]  
})
export class TestComponent implements OnInit {
  public edited = false;
  showNavigationArrows = false;
  showNavigationIndicators = false;
  /*images = [1055, 194, 368].map((n) => `https://picsum.photos/id/${n}/900/500`);*/
  images = ["assets/img/slider-1.jpg","assets/img/slider-2.jpg","assets/img/slider-2.jpg"]
  constructor(config: NgbCarouselConfig) {
    // customize default values of carousels used by this component tree
    config.showNavigationArrows = true;
    config.showNavigationIndicators = true;
  }

  ngOnInit(): void {
  }





  
  saveTodos(): void {
   //show box msg
   this.edited = true;
   //wait 3 Seconds and hide
   setTimeout(function() {
       this.edited = false;
       console.log(this.edited);
   }.bind(this), 3000);
  }

}
