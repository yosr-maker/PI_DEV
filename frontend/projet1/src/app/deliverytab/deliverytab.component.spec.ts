import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeliverytabComponent } from './deliverytab.component';

describe('DeliverytabComponent', () => {
  let component: DeliverytabComponent;
  let fixture: ComponentFixture<DeliverytabComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeliverytabComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeliverytabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
