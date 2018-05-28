import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {UserComponent} from './user.component';
import {SignInComponent} from './sign-in/sign-in.component';
import {SignUpComponent} from './sign-up/sign-up.component';
import {CustomMaterialModule} from '../angular.material';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
import {TranslateModule} from '@ngx-translate/core';
import {ResetpassComponent} from './resetpass/resetpass.component';
import {FlexLayoutModule} from '@angular/flex-layout';


@NgModule({
  imports: [
    CommonModule,
    CustomMaterialModule,
    FormsModule,
    BrowserModule,
    TranslateModule,
    ReactiveFormsModule,
    FlexLayoutModule
  ],
  exports: [
    UserComponent,
    SignInComponent,
    SignUpComponent,
    ResetpassComponent,

  ],
  declarations: [
    UserComponent,
    SignInComponent,
    SignUpComponent,
    ResetpassComponent
  ]
})
export class UserModule { }
