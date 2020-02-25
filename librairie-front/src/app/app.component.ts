import {Component, OnInit}  from '@angular/core';
import {Router}             from "@angular/router"
import {UserService}        from "../service/user.service"
import {ReservationService} from "../service/reservation.service"

@Component({
  selector: 'app-root', templateUrl: './app.component.html', styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  private panier: boolean = false;

  constructor(private userService: UserService, private router: Router, private reservationService: ReservationService) {
  }

  ngOnInit(): void {
    if (this.userService.isConnected()) {
      this.router.navigate(['librairie'])
      this.userService.user = this.userService.getUser();
    } else
      this.router.navigate(['index'])
  }

  logout() {
    this.userService.logout();
  }
}
