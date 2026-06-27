import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageMany } from './image-many';

describe('ImageMany', () => {
  let component: ImageMany;
  let fixture: ComponentFixture<ImageMany>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ImageMany],
    }).compileComponents();

    fixture = TestBed.createComponent(ImageMany);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
