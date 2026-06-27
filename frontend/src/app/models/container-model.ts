import { BaseModel } from "./base-model";
import { ImageModel } from "./image-model";
import { NodeModel } from "./node-model";
import { UserModel } from "./user-model";

export interface ContainerModel extends BaseModel {
    name: string;
    startedAt: string;
    stoppedAt: string;
    status: string;
    image: ImageModel;
    node: NodeModel;
    user: UserModel;
}