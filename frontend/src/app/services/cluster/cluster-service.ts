import { Injectable } from '@angular/core';
import { BaseService } from '../base/base-service';
import { ClusterModel } from 'app/models/cluster-model';

@Injectable({
  providedIn: 'root',
})
export class ClusterService extends BaseService<ClusterModel> {
  protected override url: string = "http://localhost:8080/api/clusters";
}
