import {Component, OnInit} from '@angular/core';
import {AuthService}       from "../service/auth.service"
import {Router}            from "@angular/router"
import {UserService}       from "../service/user.service"

@Component({
  selector   : 'app-root',
  templateUrl: './app.component.html',
  styleUrls  : ['./app.component.scss']
})
export class AppComponent implements OnInit{

  constructor(private userService: UserService, private router: Router) {
  }

  ngOnInit(): void {
    if (this.userService.isConnected)
      this.router.navigate(['librairie'])
  }
}
