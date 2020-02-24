import {Injectable}              from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http"
import {userSigninModel}         from "../models/user.signin.model"
import {User}                    from "../models/user.model"
import {Router}                  from "@angular/router"

@Injectable()
export class UserService {
  user: User

  constructor(private httpClient: HttpClient, private router: Router) {
  }

  getUser() {
    return this.user
  }

  setUser(value: User) {
    this.user = value
  }

  logout() {
    this.user = null
    this.httpClient.get("/service/user/logout")
  }

  isConnected = () => {
    return this.getUser();
  }

  register = (user: userSigninModel) => {
    return this.httpClient.post('/service/user/signIn', user)
  }

  login = (form: any) => {
    this.logout()
    const options = new HttpHeaders(form ? {authorization: 'Basic ' + btoa(form.username + ':' + form.password)} : {});
    return this.httpClient.get('/service/user/info', {headers: options});
  }

}
