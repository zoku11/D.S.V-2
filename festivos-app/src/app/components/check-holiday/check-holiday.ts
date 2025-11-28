import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FestivosService } from '../../services/festivos.service';

// Angular Material
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';

@Component({
  selector: 'app-check-holiday',
  standalone: true,
  imports: [
    FormsModule,
    MatInputModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule
  ],
  templateUrl: './check-holiday.html',
  styleUrl: './check-holiday.css'
})
export class CheckHolidayComponent {

  fecha: string = '';
  respuesta: boolean | null = null;
  countryId: number = 1;

  constructor(private festivosService: FestivosService) {}

  consultar() {
    if (!this.fecha) return;

    this.festivosService.isHoliday(this.countryId, this.fecha).subscribe({
      next: (res) => this.respuesta = res,
      error: (err) => {
        console.error(err);
        alert('Error consultando el servidor');
      }
    });
  }
}
