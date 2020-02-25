import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http"
import {Search}     from "../models/search.model"

@Injectable()
export class LibrairieService {

  constructor(private httpClient: HttpClient) {
  }


  findAll = () => {
    return this.httpClient.get("/service/librairie/findAll")
  }

  findByFields = (search: Search) => {
    return this.httpClient.post('/service/librairie/find', search)
  }

  findById = (id : string) => {
    return this.httpClient.get("/service/librairie/findById/" + Number(id))
  }
}
