import { DatePipe } from '@angular/common';
import { Component, inject } from '@angular/core';
import { BaseMany } from 'app/components/base/base-many/base-many';
import { NodeModel } from 'app/models/node-model';
import { NodeService } from 'app/services/node/node-service';

@Component({
  selector: 'app-node-many',
  imports: [DatePipe],
  templateUrl: './node-many.html',
  styleUrl: './node-many.scss',
})
export class NodeMany extends BaseMany<NodeModel> {
  protected override service: NodeService = inject(NodeService);
  protected override urlRoute: string = "nodes";
  
}
