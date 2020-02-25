import {Component, OnInit}  from '@angular/core';
import {Livre}              from "../../models/livre.model"
import {ReservationService} from "../../service/reservation.service"
import {Router}             from "@angular/router"

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.scss']
})
export class PanierComponent implements OnInit {
  collection: [Livre] = null

  constructor(private reservationService: ReservationService, private router: Router) {
  }

  ngOnInit() {
    this.collection = this.reservationService.getPanier()
  }

  deleteToPanier(livre: Livre) {
    this.reservationService.deleteToPanier(livre);
  }

  reserve() {
    this.reservationService.reserve(this.collection).subscribe(
      (response) => {
        this.reservationService.deleteAllToPanier();
        this.router.navigate(['reservation'])
      }, error => {
        console.error(error)
      }
    );
  }
}
