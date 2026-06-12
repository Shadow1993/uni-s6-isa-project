package rs.ac.singidunum.novisad.isaproject2023270048.services;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.isaproject2023270048.models.ImageModel;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.ImageRepository;

@Service
public class ImageService extends BaseService<ImageModel> {

	public ImageService(ImageRepository repo) {
		super(repo);
	}

}
