import { Component, inject } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { BaseForm } from 'app/components/base/base-form/base-form';
import { ClusterModel } from 'app/models/cluster-model';
import { ClusterService } from 'app/services/cluster/cluster-service';

@Component({
  selector: 'app-cluster-form',
  imports: [ReactiveFormsModule],
  templateUrl: './cluster-form.html',
  styleUrl: './cluster-form.scss',
})
export class ClusterForm extends BaseForm<ClusterModel> {
  protected override service: ClusterService = inject(ClusterService);
  protected override urlRoute: string = "clusters";
  override entity = new FormGroup({
    name: new FormControl("", Validators.required)
  });
  
}
