import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateEventAdminComponent } from './update-event-admin.component';

describe('UpdateEventAdminComponent', () => {
  let component: UpdateEventAdminComponent;
  let fixture: ComponentFixture<UpdateEventAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateEventAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateEventAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
