import { AssignedRoleModel } from "./assigned-role-model";
import { BaseModel } from "./base-model";

export interface UserModel extends BaseModel {
    email: string;
    password?: string;
    assignedRoles?: AssignedRoleModel[];
}