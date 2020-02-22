import {Component, OnInit} from '@angular/core';
import {LibrairieService}  from "../../service/librairie.service"
import {UserService}       from "../../service/user.service"

@Component({
  selector: 'app-librairie',
  templateUrl: './librairie.component.html',
  styleUrls: ['./librairie.component.scss']
})
export class LibrairieComponent implements OnInit {
  collection: any = null

  constructor(private librairieService: LibrairieService, private userService: UserService) {
  }

  ngOnInit() {
    this.userService.isConnected()
    this.init()
  }

  private init() {
    this.librairieService.findAll().subscribe((response) => {
      this.collection = response
      console.log(this.collection)
    }, error => {
      console.log(error)
    })
  }
}
