import { ToastrService } from 'ngx-toastr';
import { EventsComponent } from './../events/events.component';
import { EventService } from './../services/event.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Event } from '../entity/event';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contribution',
  templateUrl: './contribution.component.html',
  styleUrls: ['./contribution.component.css']
})
export class ContributionComponent implements OnInit {

  event: Event;
  amount:number;
  registerForm: FormGroup;
  submitted = false;
  constructor(private formBuilder: FormBuilder, private eventService: EventService,private toastr: ToastrService,private router: Router) { }

  ngOnInit(): void {

   
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
  else {
    this.router.navigate(["/eventList"]);
  }
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

  onReset() {
    this.submitted = false;
    this.registerForm.reset();
  }


  contribute() {
    this.eventService.addContribution(this.event.id, 2,this.amount).subscribe(res => {
      if (res)
        this.toastr.success("THANK YOU SO MUCH", "DONE", { positionClass: 'toast-x' });
      else
        this.toastr.error("YOU DONT HAVE ENOUGH MONEY ", "SORRY", { positionClass: 'toast-x' });
    });
  }

}


