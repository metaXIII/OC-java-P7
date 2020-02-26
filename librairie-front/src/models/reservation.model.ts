import DateTimeFormat = Intl.DateTimeFormat

export class Reservation {
  constructor(public id: number,
              public livreId: string,
              public dateReservation: DateTimeFormat,
              public dateLimite: DateTimeFormat,
              public extended: boolean,
              public finished: boolean) {
  }
}
