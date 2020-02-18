import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http"
import {User}       from "../models/User.model"
import {Subject}    from "rxjs"

@Injectable()
export class UserService {
  user = new Subject<User>()

  getUser() {
    return JSON.parse(localStorage.getItem("user"));
  }

  setUser(value : User) {
    this.user.next(value)
    localStorage.setItem("user",JSON.stringify(value))
  }

  logout() {
    localStorage.clear();
    this.user.next(null)
  }

  constructor(private httpClient: HttpClient) {
  }

  isConnected = () => {
    return !!localStorage.getItem("user");
  }

  register = (user: User) => {
    return this.httpClient.post('/service/user/signIn', user)
  }

  login = (user: User) => {
    return this.httpClient.post('/service/user/login', user);
  }
}
