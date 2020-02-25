import {Injectable}  from '@angular/core';
import {HttpClient}  from "@angular/common/http"
import {Livre}       from "../models/livre.model"
import {Subject}     from "rxjs"
import {UserService} from "./user.service"

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  public count            = new Subject<number>();
  private collection: any = []

  constructor(private httpClient: HttpClient, private userService: UserService) {
  }

  addToPanier = (livre: Livre) => {
    this.collection.push(livre)
    this.count.next(this.collection.length)
  }

  getPanier = () => {
    this.count.next(this.collection.length)
    return this.collection
  }

  deleteToPanier = (livre: Livre) => {
    this.collection.pop(livre)
    this.count.next(this.collection.length)
  }

  deleteAllToPanier = () => {
    this.collection = []
  }

  reserve = (collection: [Livre]) => {
    let data: any = {
      collection: collection,
      user: this.userService.getUser()
    }
    return this.httpClient.post("/service/reservation/reserve", data);
  }

  getAllReservation = () => {
    return this.httpClient.post("/service/reservation/reservations", this.userService.getUser())
  }
}
