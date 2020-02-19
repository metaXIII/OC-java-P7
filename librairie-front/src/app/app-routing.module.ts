import {NgModule}             from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent}       from "./login/login.component"
import {SigninComponent}      from "./signin/signin.component"
import {LibrairieComponent}   from "./librairie/librairie.component"
import {ConnectionComponent}  from "./connection/connection.component"
import {TestComponent}        from "./test/test.component"


const routes: Routes = [
  {path: 'index', component: ConnectionComponent},
  {path: 'login', component: LoginComponent},
  {path: 'signin', component: SigninComponent},
  {path: 'librairie', component: LibrairieComponent},
  {path: 'test', component: TestComponent},
  {path: 'welcome', component: ConnectionComponent},
  {path: '**', redirectTo: 'index'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
