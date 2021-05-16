import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParticipationListComponent } from './participation-list.component';

describe('ParticipationListComponent', () => {
  let component: ParticipationListComponent;
  let fixture: ComponentFixture<ParticipationListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ParticipationListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ParticipationListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
