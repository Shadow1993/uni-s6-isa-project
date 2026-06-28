package rs.ac.singidunum.novisad.isaproject2023270048.dtos.cluster;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.BaseDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.node.NodeDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.user.UserDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ClusterModel;

public class ClusterDTO extends BaseDTO<ClusterModel> {

	private String name;
	private UserDTOLeaf user;
	private List<NodeDTOLeaf> nodes = new ArrayList<NodeDTOLeaf>();

	public ClusterDTO() {
		super();
	}

	public ClusterDTO(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

	public ClusterDTO(String name, UserDTOLeaf user) {
		this();
		this.name = name;
		this.user = user;
	}

	public ClusterDTO(Long id, Boolean active, LocalDateTime createdAt, String name, UserDTOLeaf user) {
		this(id, active, createdAt);
		this.name = name;
		this.user = user;
	}
	
	public ClusterDTO(String name, UserDTOLeaf user, List<NodeDTOLeaf> nodes) {
		super();
		this.name = name;
		this.user = user;
		this.nodes = nodes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserDTOLeaf getUser() {
		return user;
	}

	public void setUser(UserDTOLeaf user) {
		this.user = user;
	}

	public List<NodeDTOLeaf> getNodes() {
		return nodes;
	}

	public void setNodes(List<NodeDTOLeaf> nodes) {
		this.nodes = nodes;
	}

}
