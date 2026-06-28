import { DatePipe } from '@angular/common';
import { Component, inject } from '@angular/core';
import { BaseDetail } from 'app/components/base/base-detail/base-detail';
import { ClusterModel } from 'app/models/cluster-model';
import { ClusterService } from 'app/services/cluster/cluster-service';

@Component({
  selector: 'app-cluster-detail',
  imports: [DatePipe],
  templateUrl: './cluster-detail.html',
  styleUrl: './cluster-detail.scss',
})
export class ClusterDetail extends BaseDetail<ClusterModel> {
  protected override urlRoute: string = "clusters";
  protected override service: ClusterService = inject(ClusterService);
  
}
