import {Component, OnInit} from '@angular/core';
import {LibrairieService}  from "../../service/librairie.service"

@Component({
  selector: 'app-librairie',
  templateUrl: './librairie.component.html',
  styleUrls: ['./librairie.component.scss']
})
export class LibrairieComponent implements OnInit {
  collection: any = null

  constructor(private librairieService: LibrairieService) {
  }

  ngOnInit() {
    this.init()
  }

  private init() {
    this.librairieService.findAll().subscribe((response) => {
      this.collection = response
    }, error => {
      console.log(error)
    })
  }

  private addToPanier() {
    alert("ajout au panier")
    return
  }
}
