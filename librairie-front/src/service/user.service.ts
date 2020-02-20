import {Injectable}              from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http"
import {User}                    from "../models/User.model"
import {Subject}                 from "rxjs"

@Injectable()
export class UserService {
  user = new Subject<User>()

  constructor(private httpClient: HttpClient) {
  }

  getUser() {
    return JSON.parse(localStorage.getItem("user"));
  }

  setUser(value: User) {
    //   // this.user.next(value)
    //   // localStorage.setItem("user", JSON.stringify(value))
  }

  logout() {
    //   localStorage.clear();
    //   this.user.next(null)
  }

  isConnected = () => {
    return !!localStorage.getItem("user");
  }

  register = (user: User) => {
    return this.httpClient.post('/service/user/signIn', user)
  }

  login = (user: any) => {
    const options = new HttpHeaders(user ? {authorization: 'Basic ' + btoa(user.username + ':' + user.password)} : {});
    return this.httpClient.get('/service/user/info', {headers: options});
  }

  info = () => {
    return JSON.stringify(this.httpClient.get('/service/user/info'));
  }

}
