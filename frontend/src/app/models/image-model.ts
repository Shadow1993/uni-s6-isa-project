import { BaseModel } from "./base-model";
import { UserModel } from "./user-model";

export interface ImageModel extends BaseModel {
    name: string;
    requiredRam: number;
    requiredStorage: number;
    url: string;
    version: number;
    user: UserModel;
}