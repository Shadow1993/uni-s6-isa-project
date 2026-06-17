package rs.ac.singidunum.novisad.isaproject2023270048.services;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.isaproject2023270048.models.ClusterModel;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.ClusterRepository;

@Service
public class ClusterService extends BaseService<ClusterModel, ClusterRepository> {

	public ClusterService(ClusterRepository repo) {
		super(repo);
	}

}
