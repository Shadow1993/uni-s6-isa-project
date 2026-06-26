package rs.ac.singidunum.novisad.isaproject2023270048.services;

import java.util.Comparator;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.node.NodeCreateDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.exceptions.BusinessException;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ClusterModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ImageModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.NodeModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.NodeStatusEnum;
import rs.ac.singidunum.novisad.isaproject2023270048.models.UserModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.UserPrincipal;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.NodeRepository;

@Service
public class NodeService extends BaseService<NodeModel, NodeRepository> {

	UserService userService;
	ClusterService clusterService;

	public NodeService(NodeRepository repo, UserService userService, ClusterService clusterService) {
		super(repo);
		this.userService = userService;
		this.clusterService = clusterService;
	}

	public NodeModel findBestNode(Long clusterId, ImageModel image) {
		List<NodeModel> onlineNodes = repo.findByClusterIdAndStatusAndActiveTrue(clusterId, NodeStatusEnum.ONLINE);

		return onlineNodes.stream().filter(node -> getAvailableRam(node) >= image.getRequiredRam())
				.filter(node -> getAvailableStorage(node) >= image.getRequiredStorage())
				.max(Comparator.comparingLong(this::getAvailableRam))
				.orElseThrow(() -> new BusinessException("Selected cluster has no nodes available to service request"));
	}

	private long getAvailableRam(NodeModel node) {
		long usedRam = node.getContainers().stream().mapToLong(c -> c.getImage().getRequiredRam()).sum();
		return node.getRam() - usedRam;
	}

	private long getAvailableStorage(NodeModel node) {
		long usedStorage = node.getContainers().stream().mapToLong(c -> c.getImage().getRequiredStorage()).sum();
		return node.getStorage() - usedStorage;
	}

	@Transactional
	public NodeModel create(NodeCreateDTO nodeDto) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		if (principal instanceof UserPrincipal userPrincipal) {
			UserModel user = userService.findByEmail(userPrincipal.getUsername());

			ClusterModel cluster = clusterService.findByIdActive(nodeDto.getClusterId());

			NodeModel image = new NodeModel(nodeDto.getName(), nodeDto.getRam(), nodeDto.getStorage(), nodeDto.getUrl(),
					NodeStatusEnum.ONLINE, cluster, user);

			if (image.getRam() < 1) {
				throw new BusinessException("ram cannot be less than 1 MB");
			}
			if (image.getStorage() < 1) {
				throw new BusinessException("storage cannot be less than 1 MB");
			}

			return super.create(image);
		}
		return null;

	}
}
