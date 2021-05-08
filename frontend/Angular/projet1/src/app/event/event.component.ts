import {Component, OnInit} from '@angular/core';
import {EventService} from './event.service';
import {Event} from '../Model/event';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent implements OnInit {
  events;
  listEvent: Event[];

  constructor(private s: EventService, private router: ActivatedRoute) {
  }

  ngOnInit(): void {

    this.s.getAllEventsById(this.router.snapshot.params.id).subscribe(
      (res) => {
        this.events = res;
      },
      error => {
        alert('Welcome');
      }
    );


    this.s.getEvent().subscribe(res => {
      console.log(res);
      this.listEvent = res;
    });
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
        this.events = data;
        return (this.events);
      });
  }

  getEventById(id) {
    this.s.getAllEventsById(id).subscribe(
      (data) => {
        this.events = data;
        return (this.events);
      });
  }

  deleteEvent(id: number) {
    this.s.deleteEventById(id).subscribe(() => this.s.getAllEventsById(id).subscribe(
      res => {
        this.events = res;
      }));
  }
}
