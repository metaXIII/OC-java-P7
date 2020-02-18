import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http"
import {User}       from "../models/User.model"

@Injectable()
export class UserService {

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

  getUser() {
    return JSON.parse(localStorage.getItem("user"));
  }

  logout() {
    localStorage.clear();
  }
}
