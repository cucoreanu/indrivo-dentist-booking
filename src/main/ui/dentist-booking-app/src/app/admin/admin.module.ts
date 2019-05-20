import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminPageComponent } from './pages/admin-page/admin-page.component';
import { AdminRoutingModule } from "./admin-routing.module";
import { DataTableComponent } from './data-table/data-table.component';
import {
  MatFormFieldModule,
  MatInputModule,
  MatPaginatorModule,
  MatSortModule,
  MatTableModule
} from "@angular/material";

@NgModule({
  declarations: [AdminPageComponent, DataTableComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    MatTableModule,
    MatFormFieldModule,
    MatSortModule,
    MatInputModule,
    MatPaginatorModule
  ]
})
export class AdminModule {}
