import { EventsComponent } from './../events/events.component';
import { ToastrService } from 'ngx-toastr';
import { EventService } from './../services/event.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Event } from '../entity/event';
import { Router } from '@angular/router';

@Component({
  selector: 'app-participation',
  templateUrl: './participation.component.html',
  styleUrls: ['./participation.component.css']
})
export class ParticipationComponent implements OnInit {
  event: Event;
  registerForm: FormGroup;
  submitted = false;
  constructor(private formBuilder: FormBuilder,private eventService: EventService, private toastr: ToastrService,private router: Router) { }

  ngOnInit() {


    this.event = EventsComponent.event;
    if (this.event) {
    
    function MustMatch(controlName: string, matchingControlName: string) {
        return (formGroup: FormGroup) => {
          const control = formGroup.controls[controlName];
          const matchingControl = formGroup.controls[matchingControlName];

          if (matchingControl.errors && !matchingControl.errors.mustMatch) {
            // return if another validator has already found an error on the matchingControl
            return;
          }

          // set error on matchingControl if validation fails
          if (control.value !== matchingControl.value) {
            matchingControl.setErrors({ mustMatch: true });
          } else {
            matchingControl.setErrors(null);
          }
        };
    }

    this.registerForm = this.formBuilder.group({
      title: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', Validators.required],
      acceptTerms: [false, Validators.requiredTrue]
    }, {
      validator: MustMatch('password', 'confirmPassword')
    });

  }
  else 
  this.router.navigate(["/eventList"]);
  }
  get f() { return this.registerForm.controls; }
  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }

    // display form values on success
    alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.registerForm.value, null, 4));
  }

  participate() {
    this.eventService.addParticipation(this.event.id, 2).subscribe(res => {
      if (res.startsWith("l"))
        this.toastr.success("you have participated to "+ this.event.name, "DONE", { positionClass: 'toast-x' });
      else
        this.toastr.error("EVENT PLACES / MONEY PROBLEM ", "SORRY", { positionClass: 'toast-x' });
    });
  }



  onReset() {
    this.submitted = false;
    this.registerForm.reset();
  }
}
