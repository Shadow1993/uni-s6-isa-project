import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { LoginService } from 'app/services/login/login-service';

export const rolesGuard: CanActivateFn = (route, state) => {
  let loginService = inject(LoginService);
  let router = inject(Router);

  if (loginService.validateRoles(route.data["roles"])) {
    return true;
  } else if (loginService.token == "") {
    return router.parseUrl('/login');
  } else {
    return router.parseUrl('')
  }

  // if (loginService.token != "") {
  //   return true;
  // }
  return false;
};
