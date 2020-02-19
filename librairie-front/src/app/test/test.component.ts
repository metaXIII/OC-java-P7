import { Component, OnInit } from '@angular/core';
import {UserService}         from "../../service/user.service"

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.scss']
})
export class TestComponent implements OnInit {
  value: any;

  constructor(private userService: UserService) { }

  ngOnInit() {
    console.log(this.userService.info())
    this.value = this.userService.info();
  }

}
