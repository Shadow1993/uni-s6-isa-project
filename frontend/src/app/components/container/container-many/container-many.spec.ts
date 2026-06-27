import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContainerMany } from './container-many';

describe('ContainerMany', () => {
  let component: ContainerMany;
  let fixture: ComponentFixture<ContainerMany>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ContainerMany],
    }).compileComponents();

    fixture = TestBed.createComponent(ContainerMany);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
