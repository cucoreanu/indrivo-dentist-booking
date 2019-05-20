import { Component } from '@angular/core';
import { setTheme } from "ngx-bootstrap";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  constructor() {
    setTheme('bs4'); // or 'bs4'
  }
}
