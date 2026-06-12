package rs.ac.singidunum.novisad.isaproject2023270048.dtos.cluster;

import java.time.LocalDateTime;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.BaseDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ClusterModel;

public class ClusterDTOLeaf extends BaseDTO<ClusterModel> {

	private String name;

	public ClusterDTOLeaf() {
		super();
	}

	public ClusterDTOLeaf(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

	public ClusterDTOLeaf(String name) {
		this();
		this.name = name;
	}

	public ClusterDTOLeaf(Long id, Boolean active, LocalDateTime createdAt, String name) {
		this(id, active, createdAt);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
