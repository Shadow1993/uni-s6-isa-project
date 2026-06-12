package rs.ac.singidunum.novisad.isaproject2023270048.services;

import org.springframework.stereotype.Service;

import rs.ac.singidunum.novisad.isaproject2023270048.models.RoleModel;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.RoleRepository;

@Service
public class RoleService extends BaseService<RoleModel> {

	public RoleService(RoleRepository repo) {
		super(repo);
	}

}
