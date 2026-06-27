import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserMany } from './user-many';

describe('UserMany', () => {
  let component: UserMany;
  let fixture: ComponentFixture<UserMany>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserMany],
    }).compileComponents();

    fixture = TestBed.createComponent(UserMany);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
