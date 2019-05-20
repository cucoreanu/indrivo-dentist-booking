import { AbstractControl, ValidationErrors, ValidatorFn } from "@angular/forms";

export class ValidationUtils {
  public static EMAIL = new RegExp("^([A-Za-z0-9]+[A-Za-z0-9_.-]+[A-Za-z0-9]+)@([A-Za-z0-9]+[A-Za-z0-9-]+[A-Za-z0-9]+\\.)+([A-Za-z]+)\$");
  public static PATIENT_NAME = new RegExp("^([A-Za-z]+[-]?[A-Za-z]+[ \\t]*)+$");
  public static PHONE_NUMBER = new RegExp("^[+]?\\d+\$");
}

export function regExpValidator(nameRe: RegExp): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const valid = nameRe.test(control.value);
    return valid ? null : { 'invalidFormat': { value: control.value } };
  };
}
