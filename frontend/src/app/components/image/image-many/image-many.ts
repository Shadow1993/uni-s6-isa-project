import { DatePipe } from '@angular/common';
import { Component, inject } from '@angular/core';
import { BaseMany } from 'app/components/base/base-many/base-many';
import { ImageModel } from 'app/models/image-model';
import { ImageService } from 'app/services/image/image-service';

@Component({
  selector: 'app-image-many',
  imports: [DatePipe],
  templateUrl: './image-many.html',
  styleUrl: './image-many.scss',
})
export class ImageMany extends BaseMany<ImageModel> {
  protected override service: ImageService = inject(ImageService);
  protected override urlRoute: string = "images";
  
}
