import {NgModule}             from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent}       from "./login/login.component"
import {SigninComponent}      from "./signin/signin.component"
import {LibrairieComponent}   from "./librairie/librairie.component"
import {ConnectionComponent}  from "./connection/connection.component"
import {AuthService}          from "../service/auth.service"
import {SearchComponent}      from "./search/search.component"


const routes: Routes = [
  {path: 'index', component: ConnectionComponent},
  {path: 'login', component: LoginComponent},
  {path: 'signin', component: SigninComponent},
  {path: 'librairie', component: LibrairieComponent, canActivate: [AuthService]},
  {path: 'search', component: SearchComponent, canActivate: [AuthService]},
  {path: 'welcome', component: ConnectionComponent},
  {path: '**', redirectTo: 'index'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
