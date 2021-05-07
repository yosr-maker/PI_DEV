import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulairePayementComponent } from './formulaire-payement.component';

describe('FormulairePayementComponent', () => {
  let component: FormulairePayementComponent;
  let fixture: ComponentFixture<FormulairePayementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormulairePayementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormulairePayementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
