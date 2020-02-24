import {Component, OnInit}  from '@angular/core';
import {LibrairieService}   from "../../service/librairie.service"
import {Livre}              from "../../models/livre.model"
import {ReservationService} from "../../service/reservation.service"

@Component({
  selector: 'app-librairie',
  templateUrl: './librairie.component.html',
  styleUrls: ['./librairie.component.scss']
})
export class LibrairieComponent implements OnInit {
  private collection: [Livre]

  constructor(private librairieService: LibrairieService, private reservationService: ReservationService) {
  }

  ngOnInit() {
    this.init()
  }

  private init() {
    this.librairieService.findAll().subscribe((response: [Livre]) => {
      this.collection = response
    }, error => {
      console.log(error)
    })
  }

  private addToPanier(livre : Livre) {
    this.reservationService.addToPanier(livre)
  }
}
