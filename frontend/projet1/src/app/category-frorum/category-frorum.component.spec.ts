import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryFrorumComponent } from './category-frorum.component';

describe('CategoryFrorumComponent', () => {
  let component: CategoryFrorumComponent;
  let fixture: ComponentFixture<CategoryFrorumComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CategoryFrorumComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CategoryFrorumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
