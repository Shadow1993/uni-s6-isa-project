import { DatePipe } from '@angular/common';
import { Component, inject } from '@angular/core';
import { BaseDetail } from 'app/components/base/base-detail/base-detail';
import { UserModel } from 'app/models/user-model';
import { UserService } from 'app/services/user/user-service';

@Component({
  selector: 'app-user-detail',
  imports: [DatePipe],
  templateUrl: './user-detail.html',
  styleUrl: './user-detail.scss',
})
export class UserDetail extends BaseDetail<UserModel> {
  protected override urlRoute: string = "users";
  protected override service: UserService = inject(UserService);
}
