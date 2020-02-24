import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http"
import {Livre}      from "../models/livre.model"

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  private collection: any = []

  constructor(private HttpClient: HttpClient) {
  }

  addToPanier = (livre: Livre) => {
    this.collection.push(livre)
  }

  getPanier = () => {
    return this.collection
  }

  deleteToPanier = (livre: Livre) => {
    this.collection.pop(livre)
  }
}
