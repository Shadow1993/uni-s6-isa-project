import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { LoginService } from 'app/services/login/login-service';

export const tokenInterceptor: HttpInterceptorFn = (req, next) => {
  // console.log(req);
  let loginService = inject(LoginService);
  if (loginService.token != "") {
    let newReq = req.clone({
      headers: req.headers.append("Authorization", `Bearer ${loginService.token}`)
    });
    return next(newReq);
  }
  // console.log(req);
  return next(req);
};
