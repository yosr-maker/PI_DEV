import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ToEuroConvertComponent } from './to-euro-convert.component';

describe('ToEuroConvertComponent', () => {
  let component: ToEuroConvertComponent;
  let fixture: ComponentFixture<ToEuroConvertComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ToEuroConvertComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ToEuroConvertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
