import {Component, OnInit}                  from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms"
import {User}                               from "../../models/User.model"
import {UserService}                        from "../../service/user.service"
import {Router}                             from "@angular/router"

@Component({
  selector: 'app-login', templateUrl: './login.component.html', styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup

  constructor(private formBuilder: FormBuilder, private userService: UserService, private router: Router) {
  }

  ngOnInit() {
    this.initForm();
  }

  Submit() {
    let formValue = this.loginForm.value
    let user = new User(formValue['username'], null, formValue['password']);
    console.log("connexion en cours")
    this.userService.login(user).subscribe((response) => {
      // @ts-ignore
      this.userService.setUser(response.data)
      this.router.navigate(['librairie'])
    }, error => {
      console.log(error)
    })
  }

  private initForm() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required], password: ['', Validators.required],
    })
  }
}
