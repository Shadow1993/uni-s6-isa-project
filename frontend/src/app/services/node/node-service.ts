import { Injectable } from '@angular/core';
import { BaseService } from '../base/base-service';
import { NodeModel } from 'app/models/node-model';

@Injectable({
  providedIn: 'root',
})
export class NodeService extends BaseService<NodeModel> {
  protected override url: string = "http://localhost:8080/api/nodes";
}
