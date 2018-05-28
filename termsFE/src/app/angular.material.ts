import {NgModule} from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  MatButtonModule, MatCardModule, MatDialogModule, MatInputModule, MatTableModule,
  MatToolbarModule, MatFormFieldModule, MatSelectModule, MatIconModule, MatTabsModule, MatCheckboxModule,
  MatDividerModule, MatProgressBarModule
} from '@angular/material';

@NgModule({
  imports: [
    CommonModule,
    MatFormFieldModule,
    MatToolbarModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatDialogModule,
    MatTableModule,
    MatSelectModule,
    MatIconModule,
    MatTabsModule,
    MatCheckboxModule,
    MatDividerModule,
    MatProgressBarModule],

  exports: [
    CommonModule,
    MatFormFieldModule,
    MatToolbarModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatDialogModule,
    MatTableModule,
    MatSelectModule,
    MatIconModule,
    MatTabsModule,
    MatCheckboxModule,
    MatDividerModule,
    MatProgressBarModule],
})
export class CustomMaterialModule { }
