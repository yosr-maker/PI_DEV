import { Component, OnInit } from '@angular/core';
import { AdminEventService } from '../services/admin-event.service';
import { EventService } from '../services/event.service';

@Component({
  selector: 'app-admin-event',
  templateUrl: './admin-event.component.html',
  styleUrls: ['./admin-event.component.css']
})
export class AdminEventComponent implements OnInit {

  constructor(private s: AdminEventService ){ }
  events;
  ngOnInit(): void {
    console.log()
  }
  
  submit(f) {
    this.s.addEvent(f).subscribe(
      next =>
        console.log('évenement ajouté avec success')
    )
    ;
  }
  getevent() {
    this.s.getEvent().subscribe(
      (data) => {
        console.log(data)
        this.events = data;
        return (this.events);
      });
  }
}
