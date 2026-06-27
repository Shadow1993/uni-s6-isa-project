import { Component, inject } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { BaseForm } from 'app/components/base/base-form/base-form';
import { ContainerModel } from 'app/models/container-model';
import { ContainerService } from 'app/services/container/container-service';

@Component({
  selector: 'app-container-form',
  imports: [ReactiveFormsModule],
  templateUrl: './container-form.html',
  styleUrl: './container-form.scss',
})
export class ContainerForm extends BaseForm<ContainerModel> {
  protected override service: ContainerService = inject(ContainerService);
  protected override urlRoute: string = "containers";
  override entity = new FormGroup({
    name: new FormControl("", Validators.required)
  });
  
}
