import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NodeMany } from './node-many';

describe('NodeMany', () => {
  let component: NodeMany;
  let fixture: ComponentFixture<NodeMany>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NodeMany],
    }).compileComponents();

    fixture = TestBed.createComponent(NodeMany);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
