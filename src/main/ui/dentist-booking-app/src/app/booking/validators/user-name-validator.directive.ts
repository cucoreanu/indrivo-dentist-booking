import { Directive } from '@angular/core';
import { AbstractControl, NG_VALIDATORS, ValidationErrors, Validator } from "@angular/forms";
import { regExpValidator, ValidationUtils } from "./ValidationUtils";

@Directive({
  selector: '[userName]',
  providers: [{ provide: NG_VALIDATORS, useExisting: UserNameValidatorDirective, multi: true }]
})
export class UserNameValidatorDirective implements Validator {

  validate(control: AbstractControl): ValidationErrors | null {
    return regExpValidator(ValidationUtils.PATIENT_NAME)(control);
  }

}
