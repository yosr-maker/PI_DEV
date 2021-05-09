import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserQuestionComponent } from './user-question.component';

describe('UserQuestionComponent', () => {
  let component: UserQuestionComponent;
  let fixture: ComponentFixture<UserQuestionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserQuestionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserQuestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
