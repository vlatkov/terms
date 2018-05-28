import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HomeComponent} from './home.component';
import {CustomMaterialModule} from "../angular.material";

@NgModule({
  imports: [
    CommonModule,
    CustomMaterialModule
  ],
  exports: [HomeComponent],
  declarations: [HomeComponent]
})
export class HomeModule { }
