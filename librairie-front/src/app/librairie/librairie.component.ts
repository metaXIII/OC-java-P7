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
  private error: boolean = false

  constructor(private librairieService: LibrairieService, private reservationService: ReservationService) {
  }

  ngOnInit() {
    this.init()
  }

  private init() {
    this.librairieService.findAll().subscribe((response: [Livre]) => {
      this.collection = response
      this.collection.forEach((livre: Livre) => {
        livre.quantite =
          this.reservationService.collection.filter(x => x.id == livre.id).length == livre.quantite ? 0 : livre.quantite
      })
    }, () => {
      this.error = true
    })
  }

  private addToPanier(livre: Livre) {
    let quantity = this.reservationService.collection.filter(x => x.id == livre.id).length
    if (quantity == livre.quantite) {
      livre.quantite = 0
    } else {
      livre.quantite--
      this.reservationService.addToPanier(livre)
    }
  }
}
