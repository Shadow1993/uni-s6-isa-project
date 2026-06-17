package rs.ac.singidunum.novisad.isaproject2023270048.controllers;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.cluster.ClusterDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.cluster.ClusterDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.mappers.ClusterMapper;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ClusterModel;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.ClusterRepository;
import rs.ac.singidunum.novisad.isaproject2023270048.services.ClusterService;

@RestController
@RequestMapping(value = { "/api/clusters" })
public class ClusterController extends BaseController<ClusterModel, ClusterRepository, ClusterService, ClusterDTO, ClusterDTOLeaf, ClusterMapper> {

	public ClusterController(ClusterService service, ClusterMapper mapper) {
		super(service, mapper);
	}
	
	@Override
	@GetMapping
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public List<ClusterDTO> findAll() {
		return super.findAll();
	}

}
