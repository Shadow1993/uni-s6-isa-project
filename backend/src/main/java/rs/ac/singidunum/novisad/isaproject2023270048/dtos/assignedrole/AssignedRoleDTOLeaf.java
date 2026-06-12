package rs.ac.singidunum.novisad.isaproject2023270048.dtos.assignedrole;

import java.time.LocalDateTime;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.BaseDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.models.AssignedRoleModel;

public class AssignedRoleDTOLeaf extends BaseDTO<AssignedRoleModel> {

	public AssignedRoleDTOLeaf() {
		super();
	}

	public AssignedRoleDTOLeaf(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

}
