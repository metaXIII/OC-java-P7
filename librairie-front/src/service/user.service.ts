import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http"

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private HttpClient: HttpClient) {
  }

  start = () => {
    return (this.HttpClient.get('/service/user/test'))
  }
}
