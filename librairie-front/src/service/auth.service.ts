import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {Injectable}                                                       from '@angular/core';
import {UserService}                                                      from "./user.service"

@Injectable()
export class AuthService implements CanActivate {

  constructor(private userService: UserService,
              private router: Router) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (!this.userService.isConnected) {
      this.router.navigate(['login']);
    } else {
      return true;
    }
  }
}
