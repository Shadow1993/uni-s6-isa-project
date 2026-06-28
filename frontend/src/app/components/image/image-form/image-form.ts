import { Component, inject } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { BaseForm } from 'app/components/base/base-form/base-form';
import { ImageModel } from 'app/models/image-model';
import { ImageService } from 'app/services/image/image-service';

@Component({
  selector: 'app-image-form',
  imports: [ReactiveFormsModule],
  templateUrl: './image-form.html',
  styleUrl: './image-form.scss',
})
export class ImageForm extends BaseForm<ImageModel> {
  protected override service: ImageService = inject(ImageService);
  protected override urlRoute: string = "images";
  override entity = new FormGroup({
    name: new FormControl("", Validators.required),
    requiredRam: new FormControl(0, Validators.min(1)),
    requiredStorage: new FormControl(0, Validators.min(1)),
    url: new FormControl(""),
    version: new FormControl(0, Validators.min(1))
  });
  
}
