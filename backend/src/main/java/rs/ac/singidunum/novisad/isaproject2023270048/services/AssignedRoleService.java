package rs.ac.singidunum.novisad.isaproject2023270048.services;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.isaproject2023270048.models.AssignedRoleModel;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.AssignedRoleRepository;

@Service
public class AssignedRoleService extends BaseService<AssignedRoleModel, AssignedRoleRepository> {

	public AssignedRoleService(AssignedRoleRepository repo) {
		super(repo);
	}

}
