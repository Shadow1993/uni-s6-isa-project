import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { LoginPost } from 'app/models/login-post';
import { LoginResponse } from 'app/models/login-response';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LoginService {

  private http: HttpClient = inject(HttpClient);
  private router: Router = inject(Router);

  private url = "http://localhost:8080/auth/login"
  token: string = "";

  constructor() {
    let t = localStorage.getItem("token");
    if (t !== null) {
      this.token = t;
    }
  }

  getCurrentUser(): string {
    if (this.token != "") {
      let payload = this.token.split(".")[1];
      let payloadObj = JSON.parse(atob(payload));
      return payloadObj["sub"]
    }
    return "";
  }

  isLoggedIn(): boolean {
    return this.token !== "";
  }

  login(user: LoginPost): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(`${this.url}`, user).pipe(tap((res: LoginResponse) => {
      this.token = res["token"];
      localStorage.setItem("token", this.token);
    }));
  }

  logout() {
    this.token = "";
    localStorage.removeItem("token");
    this.router.navigate(["/login"]);
  }

  getRoles() {
    if (this.token != "") {
      let payload = this.token.split(".")[1];
      let payloadObj = JSON.parse(atob(payload));
      return payloadObj["assignedRoles"]
    }
    return null;
  }

  validateRoles(roles: any) {
    let userRoles = this.getRoles();

    if (userRoles != null) {
      let skupRoles = new Set(roles);
      let skupUserRoles = new Set(userRoles);

      let rezultat = skupRoles.intersection(skupUserRoles);  // zahteva u ts.config.app.json target:esnext
      // Bilo koja rola za pristup
      if (rezultat.size > 0) {
        return true;
      }

      // Sve role potrebne
      // if (rezultat.size === skupRoles.size) {
      //   return true;
      // }
    }

    return false;
  }

}
