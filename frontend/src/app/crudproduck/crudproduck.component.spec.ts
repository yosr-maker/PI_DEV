import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrudproduckComponent } from './crudproduck.component';

describe('CrudproduckComponent', () => {
  let component: CrudproduckComponent;
  let fixture: ComponentFixture<CrudproduckComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrudproduckComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrudproduckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
