import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEventAdminComponent } from './add-event-admin.component';

describe('AddEventAdminComponent', () => {
  let component: AddEventAdminComponent;
  let fixture: ComponentFixture<AddEventAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddEventAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEventAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
