import { Component, inject } from '@angular/core';
import { BaseDetail } from 'app/components/base/base-detail/base-detail';
import { ContainerModel } from 'app/models/container-model';
import { ContainerService } from 'app/services/container/container-service';

@Component({
  selector: 'app-container-detail',
  imports: [],
  templateUrl: './container-detail.html',
  styleUrl: './container-detail.scss',
})
export class ContainerDetail extends BaseDetail<ContainerModel> {
  protected override urlRoute: string = "containers";
  protected override service: ContainerService = inject(ContainerService);
  
}
