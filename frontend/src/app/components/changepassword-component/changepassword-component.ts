import { Component, inject } from '@angular/core';
import { ReactiveFormsModule, FormGroup, FormControl, Validators } from '@angular/forms';
import { MatButton } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'app/services/login/login-service';

@Component({
  selector: 'app-changepassword-component',
  imports: [ReactiveFormsModule, MatInputModule, MatButton],
  templateUrl: './changepassword-component.html',
  styleUrl: './changepassword-component.scss',
})
export class ChangepasswordComponent {
  loginService = inject(LoginService);
  router = inject(Router);

  private snackBar = inject(MatSnackBar);

  form = new FormGroup({
    "oldPassword": new FormControl("", { validators: [Validators.required] }),
    "newPassword": new FormControl("", { validators: [Validators.required] })
  });

  changePassword() {
    if (this.form.valid) {

      const user = {
        oldPassword: this.form.value.oldPassword!,
        newPassword: this.form.value.newPassword!
      };

      this.loginService.changePassword(user).subscribe((r) => {
        this.router.navigate([""]);
        this.snackBar.open("Success!", 'X' , { duration: 3000, verticalPosition: 'top', horizontalPosition: 'right'});
      }, (e) => {
        this.snackBar.open("Error. Check info and try again", 'X' , { duration: 3000, verticalPosition: 'top', horizontalPosition: 'right'});
      });
    }
  }
}
