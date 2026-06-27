import { Injectable } from '@angular/core';
import { BaseService } from '../base/base-service';
import { RoleModel } from 'app/models/role-model';

@Injectable({
  providedIn: 'root',
})
export class RoleService extends BaseService<RoleModel> {
  protected override url: string = "http://localhost:8080/api/roles";
}
