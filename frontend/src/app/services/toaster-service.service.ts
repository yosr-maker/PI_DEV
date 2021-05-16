import { ToasterPosition } from './../events/events.component';
import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class ToasterServiceService {


  constructor(private toastr: ToastrService) {}

  public error(title: string, message: string, positionClass: ToasterPosition) {
    this.toastr.error(message, title, { positionClass });
  }


}
