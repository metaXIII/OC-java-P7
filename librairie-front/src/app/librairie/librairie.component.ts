import {Component, OnInit} from '@angular/core';
import {LibrairieService}  from "../../service/librairie.service"

@Component({
  selector: 'app-librairie',
  templateUrl: './librairie.component.html',
  styleUrls: ['./librairie.component.scss']
})
export class LibrairieComponent implements OnInit {

  constructor(private librairieService: LibrairieService) {
  }

  ngOnInit() {
    this.init()
  }

  private init() {
    this.librairieService.findAll().subscribe((resp) => {
      console.log(resp)
    }, error => {
      console.log(error)
    })
  }
}
