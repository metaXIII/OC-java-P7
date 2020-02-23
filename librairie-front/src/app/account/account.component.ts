import {Component, OnInit} from '@angular/core';
import {UserService}       from "../../service/user.service"
import {Router}            from "@angular/router"

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {
  links: any[];
  activeLinkIndex = -1;

  constructor(private router: Router, private userService: UserService) {
    this.links = [
      {
        label: 'Liste des livres disponibles',
        link: '/librairie',
        index: 0
      }, {
        label: 'Faire une recherche',
        link: '/search',
        index: 1
      }, {
        label: 'mes reservations en cours',
        link: '/reservation',
        index: 2
      }, {
        label: 'Mon panier',
        link: '/panier',
        index: 3
      }
    ];
  }

  ngOnInit() {
    this.userService.isConnected()
    this.router.events.subscribe((res) => {
      this.activeLinkIndex = this.links.indexOf(this.links.find(tab => tab.link === this.router.url));
    });
  }

}
