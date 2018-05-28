import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { SignUpComponent } from './user/sign-up/sign-up.component';
import { SignInComponent } from './user/sign-in/sign-in.component';
import {AuthGuard} from './auth/auth.guard';
import {NotFoundComponent} from './not-found/not-found.component';
import {ResetpassComponent} from "./user/resetpass/resetpass.component";


export const appRoutes: Routes = [
  { path: 'home', component: HomeComponent, canActivate: [AuthGuard] },
  {
    path: 'register', component: UserComponent,
    children: [{ path: '', component: SignUpComponent }]
  },
  {
    path: 'login', component: UserComponent,
    children: [{ path: '', component: SignInComponent }]
  },
  {path : '', redirectTo: '/login', pathMatch : 'full'},

  {
    path: 'resetpass', component: ResetpassComponent
  },
  //{path: 'dashboard', loadChildren: './core/core.module#CoreModule'},
  {path: '**', component: NotFoundComponent}

];
