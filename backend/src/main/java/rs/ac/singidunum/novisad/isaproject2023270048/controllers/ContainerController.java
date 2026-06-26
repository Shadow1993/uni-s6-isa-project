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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.container.ContainerCreateDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.container.ContainerDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.container.ContainerDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.mappers.ContainerMapper;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ContainerModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.UserPrincipal;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.ContainerRepository;
import rs.ac.singidunum.novisad.isaproject2023270048.services.ContainerService;

@RestController
@RequestMapping(value = { "/api/containers" })
public class ContainerController extends
		BaseController<ContainerModel, ContainerRepository, ContainerService, ContainerDTO, ContainerDTOLeaf, ContainerMapper> {

	public ContainerController(ContainerService service, ContainerMapper mapper) {
		super(service, mapper);
	}

	@Override
	@GetMapping(consumes = MediaType.ALL_VALUE)
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public List<ContainerDTO> findAll() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		if (principal instanceof UserPrincipal user) {
			if (user.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
				return super.findAll();
			} else if (user.getAuthorities().contains(new SimpleGrantedAuthority("USER"))) {
				return this.service.findAllActiveForUserEmail(user.getUsername()).stream()
						.map(e -> mapper.entityToDTO(e)).toList();
			}
		}
		return null;
	}

	@Override
	@GetMapping(path = "/{id}", consumes = MediaType.ALL_VALUE)
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public ContainerDTO findById(@PathVariable Long id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		if (principal instanceof UserPrincipal user) {
			if (user.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
				return super.findById(id);
			} else if (user.getAuthorities().contains(new SimpleGrantedAuthority("USER"))) {
				return mapper.entityToDTO(this.service.findByIdActiveForUserEmail(id, user.getUsername().toString()));
			}
		}
		return null;
	}

	@Hidden
	@Override
	public ContainerDTO create(ContainerDTO item) {
		return super.create(item);
	}

	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ContainerDTO create(@RequestBody ContainerCreateDTO dto) {
		return mapper.entityToDTO(service.create(dto));
	}

	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	@PutMapping(path = "/{id}/start")
	public ContainerDTO startContainer(@PathVariable Long id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		if (principal instanceof UserPrincipal user) {
			if (user.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
				return mapper.entityToDTO(this.service.startContainer(id));
			} else if (user.getAuthorities().contains(new SimpleGrantedAuthority("USER"))) {
				return mapper.entityToDTO(this.service.startContainerForUser(id, user.getUsername().toString()));
			}
		}
		return null;
	}

	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	@PutMapping(path = "/{id}/stop")
	public ContainerDTO stopContainer(@PathVariable Long id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		if (principal instanceof UserPrincipal user) {
			if (user.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
				return mapper.entityToDTO(this.service.stopContainer(id));
			} else if (user.getAuthorities().contains(new SimpleGrantedAuthority("USER"))) {
				return mapper.entityToDTO(this.service.stopContainerForUser(id, user.getUsername().toString()));
			}
		}
		return null;
	}

}
