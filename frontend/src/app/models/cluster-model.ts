import { BaseModel } from "./base-model";
import { UserModel } from "./user-model";

export interface ClusterModel extends BaseModel {
    name: string;
    user: UserModel;
}