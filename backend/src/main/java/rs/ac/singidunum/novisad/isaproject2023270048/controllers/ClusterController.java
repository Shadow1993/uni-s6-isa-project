package rs.ac.singidunum.novisad.isaproject2023270048.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.cluster.ClusterCreateDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.cluster.ClusterDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.cluster.ClusterDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.mappers.ClusterMapper;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ClusterModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.UserPrincipal;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.ClusterRepository;
import rs.ac.singidunum.novisad.isaproject2023270048.services.ClusterService;

@RestController
@RequestMapping(value = { "/api/clusters" })
public class ClusterController extends BaseController<ClusterModel, ClusterRepository, ClusterService, ClusterDTO, ClusterDTOLeaf, ClusterMapper> {

	public ClusterController(ClusterService service, ClusterMapper mapper) {
		super(service, mapper);
	}

	@Override
	@GetMapping(consumes = MediaType.ALL_VALUE)
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public List<ClusterDTO> findAll() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		if (principal instanceof UserPrincipal user) {
			if (user.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
				return super.findAll();
			} else if (user.getAuthorities().contains(new SimpleGrantedAuthority("USER"))) {
				return this.service.findAllActive().stream().map(e -> mapper.entityToDTO(e)).toList();
			}
		}
		return null;
	}

	@Override
	@GetMapping(path = "/{id}", consumes = MediaType.ALL_VALUE)
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public ClusterDTO findById(@PathVariable Long id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		if (principal instanceof UserPrincipal user) {
			if (user.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
				return super.findById(id);
			} else if (user.getAuthorities().contains(new SimpleGrantedAuthority("USER"))) {
				return mapper.entityToDTO(this.service.findByIdActive(id));
			}
		}
		return null;
	}
	
	@Hidden
	@Override
	public ClusterDTO create(ClusterDTO item) {
		return super.create(item);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ClusterDTO create(@RequestBody ClusterCreateDTO dto) {
		return mapper.entityToDTO(service.create(dto));
	}

}
