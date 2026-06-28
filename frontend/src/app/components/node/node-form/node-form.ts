import { Component, effect, inject, signal, WritableSignal } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { BaseForm } from 'app/components/base/base-form/base-form';
import { ClusterModel } from 'app/models/cluster-model';
import { NodeModel } from 'app/models/node-model';
import { BaseService } from 'app/services/base/base-service';
import { ClusterService } from 'app/services/cluster/cluster-service';
import { NodeService } from 'app/services/node/node-service';

@Component({
  selector: 'app-node-form',
  imports: [ReactiveFormsModule],
  templateUrl: './node-form.html',
  styleUrl: './node-form.scss',
})
export class NodeForm extends BaseForm<NodeModel> {
  protected override service: NodeService = inject(NodeService);
  protected override urlRoute: string = "nodes";

  protected clusterService: ClusterService = inject(ClusterService);
  protected clusters: WritableSignal<ClusterModel[]> = signal<ClusterModel[]>([]);

  constructor() {
    super();
    effect(() => {
      const e = this.ent();

      this.clusterService.getAll().subscribe((r) => {
        this.clusters.set(r);
        if (this.id() !== null && e !== null) {
          this.entity.patchValue({clusterId: e.cluster.id});
        }
      });
    });
  }

  override entity = new FormGroup({
    name: new FormControl("", Validators.required),
    ram: new FormControl(0, Validators.required),
    storage: new FormControl(0, Validators.required),
    url: new FormControl("", Validators.required),
    clusterId: new FormControl(0, Validators.required)
  });

}
