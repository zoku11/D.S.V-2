import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FestivosService } from '../../services/festivos.service';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';

// Material
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';

@Component({
  selector: 'app-list-holidays',
  standalone: true,
  imports: [
    FormsModule,
    NgxDatatableModule,
    MatInputModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule
  ],
  templateUrl: './list-holidays.html',
  styleUrl: './list-holidays.css'
})
export class ListHolidaysComponent {

  year: number = new Date().getFullYear();
  countryId: number = 1;

  rows: any[] = [];
  columns = [
    { prop: 'name', name: 'Nombre' },
    { prop: 'date', name: 'Fecha' }
  ];

  constructor(private festivosService: FestivosService) {}

  buscar() {
    this.festivosService.getHolidaysByYear(this.countryId, this.year).subscribe({
      next: (res) => {
        this.rows = res.map(entry => ({
          name: entry.holiday?.name ?? entry.key?.name ?? 'N/A',
          date: entry.value ?? entry.date ?? entry
        }));
      },
      error: (err) => {
        console.error(err);
        alert('Error al consultar festivos del año');
      }
    });
  }
}
