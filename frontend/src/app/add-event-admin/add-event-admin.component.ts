import { EventService } from './../services/event.service';
import { Component, OnInit } from '@angular/core';
import { Event } from '../entity/event';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-add-event-admin',
  templateUrl: './add-event-admin.component.html',
  styleUrls: ['./add-event-admin.component.css']
})
export class AddEventAdminComponent implements OnInit {


  event:Event= new Event();
  constructor(private eventService: EventService) { }

  ngOnInit(): void {
  }


  addEvent(){
    this.eventService.addEvent(this.event).subscribe(res=>{
      Swal.fire({
        type: 'success',
        html:  'Votre nouveau event a été créé avec succès !',
      })
    });
  }

}
