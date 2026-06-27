import { Component, inject } from '@angular/core';
import { BaseMany } from 'app/components/base/base-many/base-many';
import { ContainerModel } from 'app/models/container-model';
import { ContainerService } from 'app/services/container/container-service';

@Component({
  selector: 'app-container-many',
  imports: [],
  templateUrl: './container-many.html',
  styleUrl: './container-many.scss',
})
export class ContainerMany extends BaseMany<ContainerModel> {
  protected override service: ContainerService = inject(ContainerService);
  protected override urlRoute: string = "containers";
}
