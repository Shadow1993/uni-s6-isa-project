import { Injectable } from '@angular/core';
import { BaseService } from '../base/base-service';
import { AssignedRoleModel } from 'app/models/assigned-role-model';

@Injectable({
  providedIn: 'root',
})
export class AssignedRoleService extends BaseService<AssignedRoleModel> {
  protected override url: string = "http://localhost:8080/api/assignedroles";
}
