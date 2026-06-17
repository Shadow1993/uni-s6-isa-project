package rs.ac.singidunum.novisad.isaproject2023270048.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.role.RoleDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.role.RoleDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.mappers.RoleMapper;
import rs.ac.singidunum.novisad.isaproject2023270048.models.RoleModel;
import rs.ac.singidunum.novisad.isaproject2023270048.repositories.RoleRepository;
import rs.ac.singidunum.novisad.isaproject2023270048.services.RoleService;

@RestController
@RequestMapping(value = { "/api/roles" })
public class RoleController extends BaseController<RoleModel, RoleRepository, RoleService, RoleDTO, RoleDTOLeaf, RoleMapper> {

	public RoleController(RoleService service, RoleMapper mapper) {
		super(service, mapper);
	}

}
