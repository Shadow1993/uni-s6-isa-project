import { Component, inject } from '@angular/core';
import { FormGroup, FormControl, Validators, ReactiveFormsModule } from '@angular/forms';
import { MatButton } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'app/services/login/login-service';

@Component({
  selector: 'app-register-component',
  imports: [ReactiveFormsModule, MatInputModule, MatButton],
  templateUrl: './register-component.html',
  styleUrl: './register-component.scss',
})
export class RegisterComponent {
  loginService = inject(LoginService);
  router = inject(Router);

  private snackBar = inject(MatSnackBar);

  form = new FormGroup({
    "email": new FormControl("", { validators: [Validators.required, Validators.email] }),
    "password": new FormControl("", { validators: [Validators.required] })
  });

  register() {
    if (this.form.valid) {

      const user = {
        email: this.form.value.email!,
        password: this.form.value.password!
      };

      this.loginService.register(user).subscribe((r) => {
        this.router.navigate(["/login"]);
        this.snackBar.open("Success! You can login now!", 'X' , { duration: 3000, verticalPosition: 'top', horizontalPosition: 'right'});
      }, (e) => {
        this.snackBar.open("Error. Email most likely taken", 'X' , { duration: 3000, verticalPosition: 'top', horizontalPosition: 'right'});
      });
    }
  }

  goToLogin() {
    this.router.navigate(["/login"]);
  }
}
