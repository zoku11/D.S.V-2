import { Routes } from '@angular/router';
import { CheckHolidayComponent } from './components/check-holiday/check-holiday.component';
import { ListHolidaysComponent } from './components/list-holidays/list-holidays.component';

export const routes: Routes = [
  { path: '', component: CheckHolidayComponent },
  { path: 'list', component: ListHolidaysComponent }
];
