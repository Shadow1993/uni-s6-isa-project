package rs.ac.singidunum.novisad.isaproject2023270048.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import rs.ac.singidunum.novisad.isaproject2023270048.models.NodeModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.NodeStatusEnum;

@Repository
public interface NodeRepository extends BaseRepository<NodeModel> {

	List<NodeModel> findByClusterIdAndStatusAndActiveTrue(Long clusterId, NodeStatusEnum status);
	
}
