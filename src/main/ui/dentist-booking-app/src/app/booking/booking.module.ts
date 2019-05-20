import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookingRoutingModule } from './booking-routing.module';
import { ProcedureDetailComponent } from './components/procedure-detail/procedure-detail.component';
import { BookingPage } from "./pages/booking/booking-page.component";
import { BsDatepickerModule, TimepickerModule, TooltipModule } from "ngx-bootstrap";
import { FormsModule } from "@angular/forms";
import { UserNameValidatorDirective } from './validators/user-name-validator.directive';
import { PhoneValidatorDirective } from './validators/phone-validator.directive';
import { EmailValidatorDirective } from './validators/email-validator.directive';

@NgModule({
  declarations: [
    BookingPage,
    ProcedureDetailComponent,
    UserNameValidatorDirective,
    PhoneValidatorDirective,
    EmailValidatorDirective
  ],
  imports: [
    CommonModule,
    BookingRoutingModule,
    // Bootstrap Components
    BsDatepickerModule.forRoot(),
    FormsModule,
    TooltipModule.forRoot(),
    TimepickerModule.forRoot()
  ]
})
export class BookingModule {}
