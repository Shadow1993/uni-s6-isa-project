import { BaseModel } from "./base-model";
import { RoleModel } from "./role-model";
import { UserModel } from "./user-model";

export interface AssignedRoleModel extends BaseModel {
    user: UserModel;
    role: RoleModel;
}