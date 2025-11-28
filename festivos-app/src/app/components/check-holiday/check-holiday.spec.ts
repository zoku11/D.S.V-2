import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckHoliday } from './check-holiday';

describe('CheckHoliday', () => {
  let component: CheckHoliday;
  let fixture: ComponentFixture<CheckHoliday>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CheckHoliday]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CheckHoliday);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
