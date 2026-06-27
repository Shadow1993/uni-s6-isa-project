import { Injectable } from '@angular/core';
import { BaseService } from '../base/base-service';
import { ImageModel } from 'app/models/image-model';

@Injectable({
  providedIn: 'root',
})
export class ImageService extends BaseService<ImageModel> {
  protected override url: string = "http://localhost:8080/api/images";
}
