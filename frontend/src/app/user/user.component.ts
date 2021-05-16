import { Claim } from './../entity/claim';
import { ClaimService } from './../services/claim.service';
import { Event } from './../entity/event';
import { EventsComponent } from './../events/events.component';
import { EventService } from './../services/event.service';
import { User } from './../entity/user';
import { UserService } from './../services/user.service';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  name: string;
  user: User;
  eventList: Event[];
  claimList: Claim[];
  static event:Event ; 
  constructor(private eventService: EventService,private claimService: ClaimService) {
  }

  ngOnInit(): void {
    this.eventService.getEventList().subscribe(res => this.eventList = res);
    this.claimService.getClaimList().subscribe(res => {
      this.claimList = res,
      console.log(this.claimList);
    });
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

  deleteEvent(event:Event){
    this.eventService.deleteEvent(event.id).subscribe(() => 
      this.ngOnInit());
  }

  deleteClaim(claim:Claim){
    this.claimService.deleteClaim(claim.idClaim).subscribe(() => 
      this.ngOnInit());
  }

  copyEvent(event: Event) {
    UserComponent.event = event;
  }

  badProductList(){
    this.claimService.displayBadProductsByClaims().subscribe(res=>{
      let a=res[0];
      let b=res[1];
      let c=res[2];
      Swal.fire({
        type: 'info',
        html:  a + '<br>' + b +'<br>' + c ,
      })
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


  register() {
  }

  

}
