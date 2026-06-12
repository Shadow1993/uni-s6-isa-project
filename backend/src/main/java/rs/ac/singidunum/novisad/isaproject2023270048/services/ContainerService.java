package rs.ac.singidunum.novisad.isaproject2023270048.services;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.isaproject2023270048.models.ContainerModel;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.ContainerRepository;

@Service
public class ContainerService extends BaseService<ContainerModel> {

	public ContainerService(ContainerRepository repo) {
		super(repo);
	}

}
