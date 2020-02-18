import {Component, OnInit} from '@angular/core';
import {AuthService}       from "../service/auth.service"
import {Router}            from "@angular/router"
import {UserService}       from "../service/user.service"
import {User}              from "../models/User.model"

@Component({
  selector   : 'app-root',
  templateUrl: './app.component.html',
  styleUrls  : ['./app.component.scss']
})
export class AppComponent implements OnInit{
  user: User

  constructor(private userService: UserService, private router: Router) {
  }

  ngOnInit(): void {
    if (this.userService.isConnected()) {
      this.router.navigate(['librairie'])
      this.user = this.userService.getUser();
    }
  }

  logout() {
    this.user = null;
    this.userService.logout();
  }
}
