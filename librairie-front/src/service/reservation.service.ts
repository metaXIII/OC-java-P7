import {Injectable}  from '@angular/core';
import {HttpClient}  from "@angular/common/http"
import {Livre}       from "../models/livre.model"
import {Subject}     from "rxjs"
import {UserService} from "./user.service"
import {Reservation} from "../models/reservation.model"

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  public count            = new Subject<number>();
  public collection: any = []

  constructor(private httpClient: HttpClient, private userService: UserService) {
  }

  calculDate = (reservation: Reservation) => {
    let date1 = new Date();
    let date2 = new Date(reservation.dateLimite);
    return Math.ceil((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24))
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

  extend = (reservation: Reservation) => {
    return this.httpClient.put("/service/reservation/extend", reservation);
  }
}
