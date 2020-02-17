import {BrowserModule}      from '@angular/platform-browser';
import {NgModule}           from '@angular/core';
import {AppRoutingModule}   from './app-routing.module';
import {AppComponent}       from './app.component';
import {UserService}        from "../service/user.service"
import {HttpClientModule}   from "@angular/common/http";
import {LoginComponent}     from './login/login.component'
import {AuthService}        from "../service/auth.service"
import {CreateComponent}    from './create/create.component';
import {IndexComponent}     from './index/index.component';
import {LibrairieComponent}               from './librairie/librairie.component';
import {FormBuilder, ReactiveFormsModule} from "@angular/forms"

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CreateComponent,
    IndexComponent,
    LibrairieComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers   : [
    AuthService,
    UserService,
    FormBuilder,
    ReactiveFormsModule
  ],
  bootstrap   : [AppComponent]
})
export class AppModule {
}
