import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AskmeComponent } from './askme.component';

describe('AskmeComponent', () => {
  let component: AskmeComponent;
  let fixture: ComponentFixture<AskmeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AskmeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AskmeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
