package rs.ac.singidunum.novisad.isaproject2023270048.services;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.isaproject2023270048.exceptions.BusinessException;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ImageModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.NodeModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.NodeStatusEnum;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.NodeRepository;

@Service
public class NodeService extends BaseService<NodeModel, NodeRepository> {

	public NodeService(NodeRepository repo) {
		super(repo);
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
}
