package rs.ac.singidunum.novisad.isaproject2023270048.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.image.ImageDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.image.ImageDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.mappers.ImageMapper;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ImageModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.UserPrincipal;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.ImageRepository;
import rs.ac.singidunum.novisad.isaproject2023270048.services.ImageService;

@RestController
@RequestMapping(value = { "/api/images" })
public class ImageController extends BaseController<ImageModel, ImageRepository, ImageService, ImageDTO, ImageDTOLeaf, ImageMapper> {

	public ImageController(ImageService service, ImageMapper mapper) {
		super(service, mapper);
	}
	
	@Override
	@GetMapping(consumes = MediaType.ALL_VALUE)
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public List<ImageDTO> findAll() {
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
	public ImageDTO findById(Long id) {
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

}
