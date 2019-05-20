import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlertModule } from 'ngx-bootstrap';
import { HttpClientModule } from "@angular/common/http";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { MatSnackBarModule } from "@angular/material";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AlertModule.forRoot(),
    HttpClientModule,
    BrowserAnimationsModule,
    MatSnackBarModule
  ],
  providers: [{ provide: 'API_URL', useFactory: getApiUrl }],
  bootstrap: [AppComponent]
})
export class AppModule {}

export function getApiUrl(): string {
  const baseElement: HTMLScriptElement = (<HTMLScriptElement><any>document.getElementsByTagName('base'))[0];
  return `${baseElement.getAttribute('href')}api`;
}
