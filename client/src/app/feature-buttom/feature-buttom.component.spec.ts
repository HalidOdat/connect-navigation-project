import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeatureButtomComponent } from './feature-buttom.component';

describe('FeatureButtomComponent', () => {
  let component: FeatureButtomComponent;
  let fixture: ComponentFixture<FeatureButtomComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FeatureButtomComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FeatureButtomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
