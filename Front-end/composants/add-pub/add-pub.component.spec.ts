import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPubComponent } from './add-pub.component';

describe('AddPubComponent', () => {
  let component: AddPubComponent;
  let fixture: ComponentFixture<AddPubComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddPubComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddPubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
