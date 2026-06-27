import { AssignedRoleModel } from "./assigned-role-model";
import { BaseModel } from "./base-model";

export interface RoleModel extends BaseModel {
    name: string;
    assignedRoles: AssignedRoleModel[];
}