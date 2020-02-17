import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http"

@Injectable()
export class UserService {
  id;
  username;
  password;
  email;
  isConnected: boolean = false;

  constructor(private httpClient: HttpClient) {
  }

  start = () => {
    return this.httpClient.get('/service/user/test')
  }
}
