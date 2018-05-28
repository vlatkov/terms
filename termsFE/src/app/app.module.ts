import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {TranslateModule, TranslateLoader} from '@ngx-translate/core';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';

import { AppComponent } from './app.component';
import {SignInComponent} from './user/sign-in/sign-in.component';
import {UserComponent} from './user/user.component';
import {SignUpComponent} from './user/sign-up/sign-up.component';
import {AuthInterceptor} from './auth/auth.interceptor';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {AuthGuard} from './auth/auth.guard';
import {UserService} from './shared/user.service';
import {appRoutes} from './app.routes';
import {RouterModule} from '@angular/router';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HomeComponent} from './home/home.component';
import {ToastrModule, ToastrService} from 'ngx-toastr';
import {Configuration} from './configuration/app.constants';
import {CustomMaterialModule} from './angular.material';
import { ResetpassComponent } from './user/resetpass/resetpass.component';
import {WebpackTranslateLoader} from './shared/webpack-translate-loader';
import {UserModule} from './user/user.module';
//import {CoreModule} from './core/core.module';
import {FlexLayoutModule} from '@angular/flex-layout';
import {CookieModule, CookieService} from 'ngx-cookie';
import { LoadingBarHttpClientModule } from '@ngx-loading-bar/http-client';
import { LoadingBarModule } from '@ngx-loading-bar/core';
import {HomeModule} from "./home/home.module";
import { NotFoundComponent } from './not-found/not-found.component';


@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    //CoreModule,
    HomeModule,
    FormsModule,
    HttpClientModule,
    UserModule,
    LoadingBarHttpClientModule,
    ToastrModule.forRoot({
      timeOut: 5000,
      positionClass: 'toast-top-right',
      preventDuplicates: true
    }),

    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useClass: WebpackTranslateLoader
      }
    }),
    CookieModule.forRoot(),
    FlexLayoutModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(appRoutes),
    CustomMaterialModule,
    ReactiveFormsModule
  ],
  providers: [UserService, AuthGuard, Configuration, ToastrService,
    {
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true
    },
/*    {
      provide : HTTP_INTERCEPTORS,
      useClass : AuthInterceptor,
      multi : true
    }*/],
  bootstrap: [AppComponent]
})
export class AppModule { }

