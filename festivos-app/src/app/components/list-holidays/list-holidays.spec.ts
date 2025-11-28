import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListHolidays } from './list-holidays';

describe('ListHolidays', () => {
  let component: ListHolidays;
  let fixture: ComponentFixture<ListHolidays>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListHolidays]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListHolidays);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
