package rs.ac.singidunum.novisad.isaproject2023270048.services;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.isaproject2023270048.models.NodeModel;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.NodeRepository;

@Service
public class NodeService extends BaseService<NodeModel, NodeRepository> {

	public NodeService(NodeRepository repo) {
		super(repo);
	}

}
