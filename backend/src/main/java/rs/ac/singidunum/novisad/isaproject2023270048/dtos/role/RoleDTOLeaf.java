package rs.ac.singidunum.novisad.isaproject2023270048.dtos.role;

import java.time.LocalDateTime;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.BaseDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.models.RoleModel;

public class RoleDTOLeaf extends BaseDTO<RoleModel> {

	private String name;

	public RoleDTOLeaf() {
		super();
	}

	public RoleDTOLeaf(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

	public RoleDTOLeaf(String name) {
		super();
		this.name = name;
	}

	public RoleDTOLeaf(Long id, Boolean active, LocalDateTime createdAt, String name) {
		super(id, active, createdAt);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
