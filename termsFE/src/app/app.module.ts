import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {SignInComponent} from './user/sign-in/sign-in.component';
import {UserComponent} from './user/user.component';
import {SignUpComponent} from './user/sign-up/sign-up.component';
import {AuthInterceptor} from './auth/auth.interceptor';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {AuthGuard} from './auth/auth.guard';
import {UserService} from './shared/user.service';
import {appRoutes} from './routes';
import {RouterModule} from '@angular/router';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HomeComponent} from './home/home.component';
import {ToastrModule} from 'ngx-toastr';
import {Configuration} from './configuration/app.constants';
import {CustomMaterialModule} from './angular.material';
import { ResetpassComponent } from './user/resetpass/resetpass.component';


@NgModule({
  declarations: [
    AppComponent,
    SignUpComponent,
    UserComponent,
    SignInComponent,
    HomeComponent,
    ResetpassComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ToastrModule.forRoot(),
    BrowserAnimationsModule,
    RouterModule.forRoot(appRoutes),
    CustomMaterialModule,
    ReactiveFormsModule
  ],
  providers: [UserService, AuthGuard, Configuration,
    {
      provide : HTTP_INTERCEPTORS,
      useClass : AuthInterceptor,
      multi : true
    }],
  bootstrap: [AppComponent]
})
export class AppModule { }
