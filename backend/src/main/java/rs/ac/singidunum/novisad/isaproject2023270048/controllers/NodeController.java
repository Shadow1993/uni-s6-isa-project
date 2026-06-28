package rs.ac.singidunum.novisad.isaproject2023270048.controllers;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.node.NodeCreateDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.node.NodeDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.node.NodeDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.exceptions.PatchFailedException;
import rs.ac.singidunum.novisad.isaproject2023270048.mappers.NodeMapper;
import rs.ac.singidunum.novisad.isaproject2023270048.models.NodeModel;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.NodeRepository;
import rs.ac.singidunum.novisad.isaproject2023270048.services.NodeService;

@RestController
@RequestMapping(value = { "/api/nodes" })
public class NodeController extends BaseController<NodeModel, NodeRepository, NodeService, NodeDTO, NodeDTOLeaf, NodeMapper> {

	public NodeController(NodeService service, NodeMapper mapper) {
		super(service, mapper);
	}
	
	@Hidden
	@Override
	public NodeDTO create(NodeDTO item) {
		throw new PatchFailedException("Bad request");
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public NodeDTO create(@RequestBody NodeCreateDTO dto) {
		return mapper.entityToDTO(service.create(dto));
	}

	@Hidden
	@Override
	public NodeDTO updatePut(Long id, NodeDTO item) {
		throw new PatchFailedException("Bad request");
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public NodeDTO updatePut(@PathVariable  Long id, @RequestBody NodeCreateDTO item) {
		return mapper.entityToDTO(service.update(id, item));
	}

	@Hidden
	@Override
	public NodeDTO updatePatch(Long id, NodeDTO item) {
		throw new PatchFailedException("Bad request");
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public NodeDTO updatePatch(@PathVariable Long id, @RequestBody NodeCreateDTO item) {
		return mapper.entityToDTO(service.updatePatch(id, item));
	}
	
}
