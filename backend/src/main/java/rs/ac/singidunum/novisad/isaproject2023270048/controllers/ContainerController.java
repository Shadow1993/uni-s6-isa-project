package rs.ac.singidunum.novisad.isaproject2023270048.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.container.ContainerCreateDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.container.ContainerDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.container.ContainerDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.mappers.ContainerMapper;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ContainerModel;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.ContainerRepository;
import rs.ac.singidunum.novisad.isaproject2023270048.services.ContainerService;

@RestController
@RequestMapping(value = { "/api/containers" })
public class ContainerController extends BaseController<ContainerModel, ContainerRepository, ContainerService, ContainerDTO, ContainerDTOLeaf, ContainerMapper> {

	public ContainerController(ContainerService service, ContainerMapper mapper) {
		super(service, mapper);
	}
	

	@Hidden
	@Override
	public ContainerDTO create(ContainerDTO item) {
		return super.create(item);
	}



	@PostMapping(consumes = MediaType.ALL_VALUE)
	public ContainerDTO create(@RequestBody ContainerCreateDTO dto) {
		return mapper.entityToDTO(service.create(dto));
	}
	
	

}
