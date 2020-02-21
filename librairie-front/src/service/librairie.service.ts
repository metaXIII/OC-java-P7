import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http"

@Injectable()
export class LibrairieService {

  constructor(private HttpClient: HttpClient) {
  }


  findAll = () => {
    return this.HttpClient.get("/service/librairie/findAll")
  }
}
