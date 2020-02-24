import { Component, OnInit } from '@angular/core';
import {Livre}               from "../../models/livre.model"
import {ReservationService}  from "../../service/reservation.service"

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.scss']
})
export class PanierComponent implements OnInit {
  collection: [Livre] = null

  constructor(private reservationService: ReservationService) {}

  ngOnInit() {
    this.collection = this.reservationService.getPanier()
  }

  deleteToPanier(livre: Livre) {
    this.reservationService.deleteToPanier(livre);
  }
}
