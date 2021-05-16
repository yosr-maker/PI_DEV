import { EventService } from './../services/event.service';
import { Participation } from './../entity/Participation';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-participation-list',
  templateUrl: './participation-list.component.html',
  styleUrls: ['./participation-list.component.css']
})
export class ParticipationListComponent implements OnInit {
  participationList:Participation[];
  constructor(private eventService: EventService) { }

  ngOnInit(): void {
    this.eventService.getClientParticipation(2).subscribe(res=>this.participationList=res);
  }

}
