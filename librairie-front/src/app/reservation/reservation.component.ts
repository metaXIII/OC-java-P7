import {Component, OnInit}  from '@angular/core';
import {ReservationService} from "../../service/reservation.service"
import {LibrairieService}   from "../../service/librairie.service"
import {Reservation}        from "../../models/reservation.model"

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.scss']
})
export class ReservationComponent implements OnInit {
  reservations: any   = []
  empty: boolean      = false
  collection: any[][] = [[], []]
  private color: any

  constructor(private reservationService: ReservationService, private librairieService: LibrairieService) {
  }

  ngOnInit() {
    this.reservationService.getAllReservation().subscribe((resp: [Reservation]) => {
      resp.forEach((reservation, indexReservation) => {
        this.reservations.push(reservation)
        let el = reservation.livreId.split(',')
        el.forEach((id, indexLivre) => {
          this.librairieService.findById(id).subscribe((response) => {
            console.log("aze")
            console.log(indexReservation)
            console.log(indexLivre)
            console.log(this.collection)
            this.collection[indexReservation][indexLivre] = [response]
          }, (error) => {
            console.error(error)
          })
        })
      })
    }, error => {
      this.empty = true
    })
    console.log(this.reservations)
  }

  getDateCalculate(dateReservation: any, dateLimite: any) {
    let date1 = new Date(dateReservation);
    let date2 = new Date(dateLimite);
    let date  = (date2.getTime() - date1.getTime()) / (1000 * 3600 * 24)
    return date;
  }
}
