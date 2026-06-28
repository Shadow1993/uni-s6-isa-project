import { DatePipe } from '@angular/common';
import { Component, inject } from '@angular/core';
import { BaseMany } from 'app/components/base/base-many/base-many';
import { UserModel } from 'app/models/user-model';
import { UserService } from 'app/services/user/user-service';

@Component({
  selector: 'app-user-many',
  imports: [DatePipe],
  templateUrl: './user-many.html',
  styleUrl: './user-many.scss',
})
export class UserMany extends BaseMany<UserModel> {
  protected override service: UserService = inject(UserService);
  protected override urlRoute: string = "users";
  
}
