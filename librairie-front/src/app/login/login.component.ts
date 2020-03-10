import {Component, OnInit}                  from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms"
import {User}                               from "../../models/user.model"
import {UserService}                        from "../../service/user.service"
import {Router}                             from "@angular/router"

@Component({
  selector: 'app-login', templateUrl: './login.component.html', styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup
  error: boolean = false

  constructor(private formBuilder: FormBuilder, private userService: UserService, private router: Router) {
  }

  ngOnInit() {
    this.initForm();
  }

  Submit() {
    let formValue = this.loginForm.value
    let user      = {username: formValue['username'], password: formValue['password']}
    this.userService.login(user).subscribe((response: User) => {
      this.userService.setUser(response)
      this.router.navigate(['librairie'])
    }, error => {
      console.log(error)
      this.error = true
    })
  }

  private initForm() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required], password: ['', Validators.required],
    })
  }
}
