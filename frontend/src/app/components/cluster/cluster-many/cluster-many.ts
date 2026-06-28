import { DatePipe } from '@angular/common';
import { Component, inject } from '@angular/core';
import { BaseMany } from 'app/components/base/base-many/base-many';
import { ClusterModel } from 'app/models/cluster-model';
import { ClusterService } from 'app/services/cluster/cluster-service';

@Component({
  selector: 'app-cluster-many',
  imports: [DatePipe],
  templateUrl: './cluster-many.html',
  styleUrl: './cluster-many.scss',
})
export class ClusterMany extends BaseMany<ClusterModel> {
  protected override service: ClusterService = inject(ClusterService);
  protected override urlRoute: string = "clusters";
  
}
