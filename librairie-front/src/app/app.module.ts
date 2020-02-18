import {BrowserModule}                    from '@angular/platform-browser';
import {NgModule}                         from '@angular/core';
import {AppRoutingModule}                 from './app-routing.module';
import {AppComponent}                     from './app.component';
import {UserService}                      from "../service/user.service"
import {HttpClientModule}                 from "@angular/common/http";
import {LoginComponent}                   from './login/login.component'
import {AuthService}                      from "../service/auth.service"
import {SigninComponent}                  from './signin/signin.component';
import {ConnectionComponent}              from './connection/connection.component';
import {LibrairieComponent}                            from './librairie/librairie.component';
import {FormBuilder, FormsModule, ReactiveFormsModule} from "@angular/forms"

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SigninComponent,
    ConnectionComponent,
    LibrairieComponent
  ], imports: [HttpClientModule, BrowserModule, AppRoutingModule, ReactiveFormsModule, FormsModule],
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
