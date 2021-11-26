import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HcaDashboardComponent } from './hca-dashboard.component';

describe('HcaDashboardComponent', () => {
  let component: HcaDashboardComponent;
  let fixture: ComponentFixture<HcaDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HcaDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HcaDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
