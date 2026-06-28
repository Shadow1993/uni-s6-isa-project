import { Directive, inject, OnInit, signal, WritableSignal } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { MatSnackBar } from "@angular/material/snack-bar";
import { Router } from "@angular/router";
import { ConfirmDialogComponent } from "app/components/dialogs/confirm-dialog-component/confirm-dialog-component";
import { BaseModel } from "app/models/base-model";
import { ConfirmDialog } from "app/models/confirm-dialog";
import { BaseService } from "app/services/base/base-service";
import { LoginService } from "app/services/login/login-service";

@Directive()
export abstract class BaseMany<T extends BaseModel> implements OnInit {

  protected abstract service: BaseService<T>;

  private snackBar = inject(MatSnackBar);
  protected router: Router = inject(Router);

  private loginService: LoginService = inject(LoginService);

  protected entities: WritableSignal<T[]> = signal<T[]>([]);
  protected abstract urlRoute: string;

  protected data: ConfirmDialog = {
    title: 'Confirm Delete Action',
    message: 'Are you sure you want to delete this item?',
    confirmText: 'Yes, Delete',
    cancelText: 'Cancel'
  }

  private dialog: MatDialog = inject(MatDialog);

  ngOnInit(): void {
    this.refresh();
  }

  refresh() {
    this.service.getAll().subscribe({
      next: (entities: T[]) => {
        // console.log(entities);
        this.entities.set(entities)
      },
      error: (err: any) => {
        this.snackBar.open("Please login again", 'X', { duration: 3000, verticalPosition: 'top', horizontalPosition: 'right' });
        this.loginService.logout();
      }
    });
  }

  delete(id: number): void {
    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      width: '400px',
      data: this.data
    });

    dialogRef.afterClosed().subscribe((result: boolean) => {
      if (result) {

        this.service.delete(id).subscribe({
          next: (entity: T) => {
            this.snackBar.open("Deleted item successfully", 'X', { duration: 3000, verticalPosition: 'top', horizontalPosition: 'right' });
            this.refresh()
          },
          error: (error: any) => {
            this.snackBar.open("Something went wrong. Item not deleted", 'X', { duration: 3000, verticalPosition: 'top', horizontalPosition: 'right' });
          }
        });

      }
    });
  }

  update(id: number) {
    this.router.navigateByUrl(`${this.urlRoute}/${id}/edit`);
  }

  add() {
    this.router.navigateByUrl(`${this.urlRoute}/new`);
  }

  detail(id: number) {
    this.router.navigateByUrl(`${this.urlRoute}/${id}`);
  }

  validateRoles(roles: any) {
    return this.loginService.validateRoles(roles);
  }
}