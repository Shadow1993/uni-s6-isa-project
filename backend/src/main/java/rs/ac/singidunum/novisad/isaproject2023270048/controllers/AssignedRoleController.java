package rs.ac.singidunum.novisad.isaproject2023270048.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.assignedrole.AssignedRoleDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.assignedrole.AssignedRoleDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.mappers.AssignedRoleMapper;
import rs.ac.singidunum.novisad.isaproject2023270048.models.AssignedRoleModel;
import rs.ac.singidunum.novisad.isaproject2023270048.services.AssignedRoleService;

@RestController
@RequestMapping(value = { "/api/assignedroles" })
public class AssignedRoleController extends BaseController<AssignedRoleModel, AssignedRoleDTO, AssignedRoleDTOLeaf, AssignedRoleMapper> {

	public AssignedRoleController(AssignedRoleService service, AssignedRoleMapper mapper) {
		super(service, mapper);
	}

}
