package rs.ac.singidunum.novisad.isaproject2023270048.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.container.ContainerCreateDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.exceptions.BusinessException;
import rs.ac.singidunum.novisad.isaproject2023270048.exceptions.ResourceNotFoundException;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ContainerModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ContainerStatusEnum;
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
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		if (principal instanceof UserPrincipal userPrincipal) {
			UserModel user = userService.findByEmail(userPrincipal.getUsername());
			ImageModel image = imageService.findById(createDto.getImageId());
			NodeModel node = nodeService.findBestNode(createDto.getClusterId(), image);

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
	
	public ContainerModel startContainer(Long id) {
		ContainerModel container = findByIdActive(id);
		return startContainerHelper(container);
	}
	
	public ContainerModel startContainerForUser(Long id, String email) {
		ContainerModel container = findByIdActiveForUserEmail(id, email);
		return startContainerHelper(container);
	}
	
	private ContainerModel startContainerHelper(ContainerModel container) {
		if (container.getStatus().equals(ContainerStatusEnum.RUNNING)) {
			throw new BusinessException("Container already running");
		}
		container.setStartedAt(LocalDateTime.now());
		container.setStoppedAt(null);
		container.setStatus(ContainerStatusEnum.RUNNING);
		return repo.save(container);
	}
	
	public ContainerModel stopContainer(Long id) {
		ContainerModel container = findByIdActive(id);
		return stopContainerHelper(container);
	}
	
	public ContainerModel stopContainerForUser(Long id, String email) {
		ContainerModel container = findByIdActiveForUserEmail(id, email);
		return stopContainerHelper(container);
	}
	
	private ContainerModel stopContainerHelper(ContainerModel container) {
		if (container.getStatus().equals(ContainerStatusEnum.STOPPED)) {
			throw new BusinessException("Container is not running");
		}
		container.setStoppedAt(LocalDateTime.now());
		container.setStatus(ContainerStatusEnum.STOPPED);
		return repo.save(container);
	}

}
