package rs.ac.singidunum.novisad.isaproject2023270048.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.image.ImageDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.image.ImageDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.mappers.ImageMapper;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ImageModel;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.ImageRepository;
import rs.ac.singidunum.novisad.isaproject2023270048.services.ImageService;

@RestController
@RequestMapping(value = { "/api/images" })
public class ImageController extends BaseController<ImageModel, ImageRepository, ImageService, ImageDTO, ImageDTOLeaf, ImageMapper> {

	public ImageController(ImageService service, ImageMapper mapper) {
		super(service, mapper);
	}

}
