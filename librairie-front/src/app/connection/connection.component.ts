import {Component, OnInit} from '@angular/core';
import {UserService}       from "../../service/user.service"
import {Router}            from "@angular/router"

@Component({
  selector: 'app-connection',
  templateUrl: './connection.component.html',
  styleUrls: ['./connection.component.scss']
})
export class ConnectionComponent implements OnInit {

  constructor(private userService: UserService, private router: Router) {
  }

  ngOnInit() {
    if (this.userService.getUser()) {
      this.router.navigate(['librairie'])
    }
  }

}
