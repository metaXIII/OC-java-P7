import {Component, OnInit}                  from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms"
import {User}                               from "../../models/user.model"
import {UserService}                        from "../../service/user.service"
import {Router}                             from "@angular/router"

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
      username     : ['', Validators.required],
      password     : ['', Validators.required],
      checkPassword: ['', Validators.required],
      email        : ['', Validators.email]
    })
  }

  private Submit() {
    console.log("Inscription en cours")
    let formValue = this.signinForm.value
    if (formValue['password'] == formValue['checkPassword']) {
      console.log('appel au microservice')
      this.userService.register(new User(formValue['username'], formValue['email'], formValue['password'])).subscribe((response) => {
        console.log("L'inscription s'est bien déroulée")
        this.router.navigate(['librairie'])
      }, error => {
        console.log(error)
        console.log("une erreur est survenue")
      })
    } else this.msg = true
  }

}
