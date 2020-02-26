export class Reservation {
  constructor(public id: number,
              public livreId: string,
              public dateReservation: Date,
              public dateLimite: Date,
              public extended: boolean,
              public finished: boolean) {
  }
}
