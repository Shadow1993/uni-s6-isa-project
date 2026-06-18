package rs.ac.singidunum.novisad.isaproject2023270048.services;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.container.ContainerCreateDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.exceptions.ResourceNotFoundException;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ContainerModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ImageModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.NodeModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.UserModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.UserPrincipal;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.ContainerRepository;

@Service
public class ContainerService extends BaseService<ContainerModel, ContainerRepository> {

	private ImageService imageService;
	private NodeService nodeService;
	private UserService userService;

	public ContainerService(ContainerRepository repo, ImageService imageService, NodeService nodeService,
			UserService userService) {
		super(repo);
		this.imageService = imageService;
		this.nodeService = nodeService;
		this.userService = userService;
	}

	@Transactional
	public ContainerModel create(ContainerCreateDTO createDto) {
		ImageModel image = imageService.findById(createDto.getImageId());
		NodeModel node = nodeService.findBestNode(createDto.getClusterId(), image);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		if (principal instanceof UserPrincipal userPrincipal) {
			UserModel user = userService.findByEmail(userPrincipal.getUsername());

			ContainerModel container = new ContainerModel(createDto.getName(), image, node, user);
			return super.create(container);
		}
		return null;

	}

	public List<ContainerModel> findAllActiveForUserEmail(String email) {
		UserModel user = userService.findByEmail(email);
		return repo.findAllByActiveTrueAndUserId(user.getId());
	}
	
	public ContainerModel findByIdActiveForUserEmail(Long id, String email) {
		UserModel user = userService.findByEmail(email);
		return repo.findByIdAndActiveTrueAndUserId(id, user.getId()).orElseThrow(() -> new ResourceNotFoundException("Item not found"));
	}

}
