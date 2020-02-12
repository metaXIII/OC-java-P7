import {Component, OnInit} from '@angular/core';
import {UserService} from "../service/user.service"

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  value: string;

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
    this.userService.start().subscribe(
      (response: any) => {
        this.value = response.data;
      }, (error => {
        console.log('une erreur est survenue')
      })
    );
  }
}
