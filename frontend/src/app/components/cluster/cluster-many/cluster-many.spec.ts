import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClusterMany } from './cluster-many';

describe('ClusterMany', () => {
  let component: ClusterMany;
  let fixture: ComponentFixture<ClusterMany>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClusterMany],
    }).compileComponents();

    fixture = TestBed.createComponent(ClusterMany);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
