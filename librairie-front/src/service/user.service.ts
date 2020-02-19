import {Injectable}              from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http"
import {User}                    from "../models/User.model"
import {Subject}                 from "rxjs"

@Injectable()
export class UserService {
  user = new Subject<User>()
  private options = {headers: new HttpHeaders().set('Content-Type', 'application/json')};

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
    return this.httpClient.post('/service/user/login', user, this.options);
  }

  info = () => {
    return JSON.stringify(this.httpClient.get('/service/user/info'));
  }

}
