package rs.ac.singidunum.novisad.isaproject2023270048.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.container.ContainerDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.container.ContainerDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.mappers.ContainerMapper;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ContainerModel;
import rs.ac.singidunum.novisad.isaproject2023270048.services.ContainerService;

@RestController
@RequestMapping(value = { "/api/containers" })
public class ContainerController
		extends BaseController<ContainerModel, ContainerDTO, ContainerDTOLeaf, ContainerMapper> {

	public ContainerController(ContainerService service, ContainerMapper mapper) {
		super(service, mapper);
	}

}
