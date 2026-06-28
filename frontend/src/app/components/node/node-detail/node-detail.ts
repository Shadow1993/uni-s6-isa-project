import { DatePipe } from '@angular/common';
import { Component, inject } from '@angular/core';
import { BaseDetail } from 'app/components/base/base-detail/base-detail';
import { NodeModel } from 'app/models/node-model';
import { NodeService } from 'app/services/node/node-service';

@Component({
  selector: 'app-node-detail',
  imports: [DatePipe],
  templateUrl: './node-detail.html',
  styleUrl: './node-detail.scss',
})
export class NodeDetail extends BaseDetail<NodeModel> {
  protected override urlRoute: string = "nodes";
  protected override service: NodeService = inject(NodeService);
}
