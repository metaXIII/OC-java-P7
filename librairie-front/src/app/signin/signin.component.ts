import {Component, OnInit}                  from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms"
import {UserService}                        from "../../service/user.service"
import {Router}                             from "@angular/router"
import {userSigninModel}                    from "../../models/user.signin.model"
import {User}                               from "../../models/user.model"

@Component({
  selector: 'app-signin', templateUrl: './signin.component.html', styleUrls: ['./signin.component.scss']
})
export class SigninComponent implements OnInit {
  private signinForm: FormGroup
  private msg: boolean = false

  constructor(private formBuilder: FormBuilder, private userService: UserService, private router: Router) {
  }

  ngOnInit() {
    this.initForm()
  }

  private initForm() {
    this.signinForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      checkPassword: ['', Validators.required],
      email: ['', Validators.email]
    })
  }

  private Submit() {
    let formValue = this.signinForm.value
    if (formValue['password'] !== formValue['checkPassword']) {
      this.msg = true
      return;
    }
    console.log('appel au microservice')
    this.userService.register(new userSigninModel(formValue['username'], formValue['email'], formValue['password']))
      .subscribe(() => {
        this.router.navigate(['index'])
      }, error => {
        console.log(error)
        console.log("une erreur est survenue")
      })
  }

}
