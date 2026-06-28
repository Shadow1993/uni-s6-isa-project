import { DatePipe } from '@angular/common';
import { Component, inject } from '@angular/core';
import { BaseDetail } from 'app/components/base/base-detail/base-detail';
import { ImageModel } from 'app/models/image-model';
import { ImageService } from 'app/services/image/image-service';

@Component({
  selector: 'app-image-detail',
  imports: [DatePipe],
  templateUrl: './image-detail.html',
  styleUrl: './image-detail.scss',
})
export class ImageDetail extends BaseDetail<ImageModel> {
  protected override urlRoute: string = "images";
  protected override service: ImageService = inject(ImageService);
}
