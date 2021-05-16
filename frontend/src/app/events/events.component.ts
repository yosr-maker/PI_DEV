import { Event } from './../entity/event';
import { Component, OnInit } from '@angular/core';
import { EventService } from '../services/event.service';
import { ToastrService } from 'ngx-toastr';
import Swal from 'sweetalert2';

// this is a Node object    
var span = document.createElement("span");



export enum ToasterPosition {
  topRight = 'toast-top-right',
  topLeft = 'toast-top-left',
  bottomRight = 'toast-bottom-right',
  bottomLeft = 'toast-bottom-left',
  mine = 'toast-x'
  // Other positions you would like
}


@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {
  
  constructor(private eventService: EventService) { }

  static event: Event;
  name: string;
  category:string;
  eventList: Event[];
  statList;
  ngOnInit(): void {
    this.eventService.getEventList().subscribe(res => this.eventList = res);
  }

  copyEvent(event: Event) {
    EventsComponent.event = event;
    console.log(EventsComponent.event);
  }

  getEventByName() {
    this.eventService.getEventByName(this.name).subscribe(res => {
      if (res) {
        this.eventList = [];
        this.eventList.push(res);
      }
      else this.eventList = [];
    });
  }


  getEventByCategory() {
    this.eventService.getEventByCategory(this.category).subscribe(res => {
      if (res) {
        this.eventList = res ;
      }
    },err =>{
      if (err) {
        this.eventList = [];
      }
    });
  }

  bestEventParticipation(){
    this.eventService.displayBestEventsByParticipations().subscribe(res=>{
      let a=res[0];
      let b=res[1];
      let c=res[2];
      Swal.fire({
        type: 'info',
        html:  a + '<br>' + b +'<br>' + c ,
      })
    });
  }


  bestEventCollects(){
    this.eventService.displayBestEventsByCollects().subscribe(res=>{
      let a=res[0];
      let b=res[1];
      let c=res[2];
      Swal.fire({
        type: 'info',
        html:  a + '<br>' + b +'<br>' + c ,
      })
    });
  }


}
