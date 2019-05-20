import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookingPage } from "./pages/booking/booking-page.component";

const routes: Routes = [
  { path: '', component: BookingPage },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookingRoutingModule {}
