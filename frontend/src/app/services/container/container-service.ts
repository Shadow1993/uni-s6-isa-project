import { Injectable } from '@angular/core';
import { BaseService } from '../base/base-service';
import { ContainerModel } from 'app/models/container-model';

@Injectable({
  providedIn: 'root',
})
export class ContainerService extends BaseService<ContainerModel> {
  protected override url: string = "http://localhost:8080/api/containers";

  start(id: number) {
    return this.http.put<ContainerModel>(`${this.url}/${id}/start`, null);
  }

  stop(id: number) {
    return this.http.put<ContainerModel>(`${this.url}/${id}/stop`, null);
  }
}
