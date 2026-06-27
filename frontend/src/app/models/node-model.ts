import { BaseModel } from "./base-model";
import { ClusterModel } from "./cluster-model";
import { ContainerModel } from "./container-model";
import { UserModel } from "./user-model";

export interface NodeModel extends BaseModel {
    name: string;
    ram: number;
    storage: number;
    url: string;
    status: string;
    cluster: ClusterModel;
    user: UserModel;
    containers: ContainerModel[];
}