import {NgModule}             from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent}       from "./login/login.component"
import {CreateComponent}      from "./create/create.component"
import {LibrairieComponent} from "./librairie/librairie.component"
import {IndexComponent}     from "./index/index.component"


const routes: Routes = [
  {path: 'index', component: IndexComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: CreateComponent},
  {path: 'librairie', component: LibrairieComponent},
  {path: '**', redirectTo: 'index'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
