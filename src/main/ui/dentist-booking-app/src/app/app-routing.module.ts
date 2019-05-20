import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'booking', loadChildren: './booking/booking.module#BookingModule' },
  { path: '', redirectTo: 'booking', pathMatch: 'full' },
  { path: 'admin', loadChildren: './admin/admin.module#AdminModule' },
  { path: '**', redirectTo: 'booking', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
