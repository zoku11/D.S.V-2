import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FestivosService {

  private api = '/api/holidays';   

  constructor(private http: HttpClient) {}

  
  isHoliday(countryId: number, date: string): Observable<boolean> {
    return this.http.get<boolean>(
      `${this.api}/country/${countryId}/is-holiday?date=${date}`
    );
  }

  getHolidaysByYear(countryId: number, year: number): Observable<any[]> {
    return this.http.get<any[]>(
      `${this.api}/country/${countryId}/year/${year}`
    );
  }

}
