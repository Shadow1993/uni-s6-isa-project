import { Component, effect, inject, signal, WritableSignal } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { BaseForm } from 'app/components/base/base-form/base-form';
import { ClusterModel } from 'app/models/cluster-model';
import { ContainerModel } from 'app/models/container-model';
import { ImageModel } from 'app/models/image-model';
import { ClusterService } from 'app/services/cluster/cluster-service';
import { ContainerService } from 'app/services/container/container-service';
import { ImageService } from 'app/services/image/image-service';

@Component({
  selector: 'app-container-form',
  imports: [ReactiveFormsModule],
  templateUrl: './container-form.html',
  styleUrl: './container-form.scss',
})
export class ContainerForm extends BaseForm<ContainerModel> {
  protected override service: ContainerService = inject(ContainerService);
  protected override urlRoute: string = "containers";
  protected imageService: ImageService = inject(ImageService);
  protected clusterService: ClusterService = inject(ClusterService);

  protected images: WritableSignal<ImageModel[]> = signal<ImageModel[]>([]);
  protected clusters: WritableSignal<ClusterModel[]> = signal<ClusterModel[]>([]);

  constructor() {
    super();
    effect(() => {
      const e = this.ent();
      this.imageService.getAll().subscribe((r) => {
        this.images.set(r);
        if (this.id() !== null) {
          this.entity.patchValue({ imageId: this.ent()?.image.id });
        }
      });
      this.clusterService.getAll().subscribe((r) => {
        this.clusters.set(r);
        if (this.id() !== null && e !== null) {
          // console.log(this.clusters());
          // console.log(this.clusters().find((v) => v.nodes.find((n)=> n.id === e.node.id))?.id);
          this.entity.patchValue({ clusterId: this.clusters().find((v) => v.nodes.find((n)=> n.id === e.node.id))?.id })
        }
      });
    });
  }

  override entity = new FormGroup({
    name: new FormControl("", Validators.required),
    imageId: new FormControl(0, Validators.required),
    clusterId: new FormControl(0, Validators.required)
  });

}
