import {Injectable}              from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http"
import {User}                    from "../models/user.model"

@Injectable()
export class UserService {
  user: User

  constructor(private httpClient: HttpClient) {
  }

  getUser() {
    return this.user
  }

  setUser(value: User) {
    this.user = value
  }

  logout() {
      this.user = null
  }

  isConnected = () => {
    return !!localStorage.getItem("user");
  }

  register = (user: User) => {
    return this.httpClient.post('/service/user/signIn', user)
  }

  login = (form: any) => {
    const options = new HttpHeaders(form ? {authorization: 'Basic ' + btoa(form.username + ':' + form.password)} : {});
    return this.httpClient.get('/service/user/info', {headers: options});
  }

}
