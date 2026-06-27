import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClusterForm } from './cluster-form';

describe('ClusterForm', () => {
  let component: ClusterForm;
  let fixture: ComponentFixture<ClusterForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClusterForm],
    }).compileComponents();

    fixture = TestBed.createComponent(ClusterForm);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
