import {NgModule} from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  MatButtonModule, MatCardModule, MatDialogModule, MatInputModule, MatTableModule,
  MatToolbarModule, MatFormFieldModule, MatSelectModule, MatIconModule, MatTabsModule
} from '@angular/material';

@NgModule({
  imports: [MatFormFieldModule, CommonModule, MatToolbarModule, MatButtonModule, MatCardModule, MatInputModule,
    MatDialogModule, MatTableModule, MatSelectModule, MatIconModule, MatTabsModule],
  exports: [MatFormFieldModule, CommonModule, MatToolbarModule, MatButtonModule, MatCardModule, MatInputModule,
    MatDialogModule, MatTableModule, MatSelectModule, MatIconModule, MatTabsModule],
})
export class CustomMaterialModule { }
