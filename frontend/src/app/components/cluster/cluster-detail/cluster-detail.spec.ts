import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClusterDetail } from './cluster-detail';

describe('ClusterDetail', () => {
  let component: ClusterDetail;
  let fixture: ComponentFixture<ClusterDetail>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClusterDetail],
    }).compileComponents();

    fixture = TestBed.createComponent(ClusterDetail);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
