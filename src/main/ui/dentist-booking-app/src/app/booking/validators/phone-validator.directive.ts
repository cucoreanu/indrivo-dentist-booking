import { Directive } from '@angular/core';
import { AbstractControl, NG_VALIDATORS, ValidationErrors, Validator } from "@angular/forms";
import { regExpValidator, ValidationUtils } from "./ValidationUtils";

@Directive({
  selector: '[phoneNumber]',
  providers: [{ provide: NG_VALIDATORS, useExisting: PhoneValidatorDirective, multi: true }]
})
export class PhoneValidatorDirective implements Validator {

  validate(control: AbstractControl): ValidationErrors | null {
    return regExpValidator(ValidationUtils.PHONE_NUMBER)(control);
  }

}
