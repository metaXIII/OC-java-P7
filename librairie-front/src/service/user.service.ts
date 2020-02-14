import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http"

@Injectable()
export class UserService {

  constructor(private httpClient: HttpClient) {
  }

  start = () => {
    return this.httpClient.get('/service/user/test')
  }
}
