import { Contribution } from './../entity/Contribution';
import { User } from './../entity/user';
import { UserComponent } from './../user/user.component';
import { EventService } from './../services/event.service';
import { Participation } from './../entity/Participation';
import { ParticipationComponent } from './../participation/participation.component';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-event-participation',
  templateUrl: './event-participation.component.html',
  styleUrls: ['./event-participation.component.css']
})
export class EventParticipationComponent implements OnInit {
  showTotal=false;
  participationList:Participation[];
  totalContribution:number=0;
  constructor(private eventService: EventService) { }

  ngOnInit(): void {
    this.eventService.getEventParticipation(UserComponent.event.id).subscribe(res=>{this.participationList=res;
      for (let i =0 ; i<this.participationList[0].client.contribution.length;i++){
        this.totalContribution+=this.participationList[0].client.contribution[i].amount;
      }
    });
  }

  sum(contribution:Contribution[]){
    this.totalContribution=0;
    for(let i = 0 ; i< contribution.length; i ++){
      this.showTotal=true;
      this.totalContribution+=contribution[i].amount;
    }
  }
}
