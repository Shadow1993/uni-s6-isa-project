package rs.ac.singidunum.novisad.isaproject2023270048.dtos.node;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.BaseDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.cluster.ClusterDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.container.ContainerDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.user.UserDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.models.NodeModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.NodeStatusEnum;

public class NodeDTO extends BaseDTO<NodeModel> {

	private String name;
	private Long ram = 0l;
	private Long storage = 0l;
	private String url;
	private NodeStatusEnum status;
	private ClusterDTOLeaf cluster;
	private UserDTOLeaf user;
	private List<ContainerDTOLeaf> containers = new ArrayList<ContainerDTOLeaf>();

	public NodeDTO() {
		super();
	}

	public NodeDTO(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

	public NodeDTO(String name, Long ram, Long storage, String url, NodeStatusEnum status, ClusterDTOLeaf cluster,
			UserDTOLeaf user) {
		this();
		this.name = name;
		this.ram = ram;
		this.storage = storage;
		this.url = url;
		this.status = status;
		this.cluster = cluster;
		this.user = user;
	}

	public NodeDTO(String name, Long ram, Long storage, String url, NodeStatusEnum status, ClusterDTOLeaf cluster,
			UserDTOLeaf user, List<ContainerDTOLeaf> containers) {
		this();
		this.name = name;
		this.ram = ram;
		this.storage = storage;
		this.url = url;
		this.status = status;
		this.cluster = cluster;
		this.user = user;
		this.containers = containers;
	}

	public NodeDTO(Long id, Boolean active, LocalDateTime createdAt, String name, Long ram, Long storage, String url,
			NodeStatusEnum status, ClusterDTOLeaf cluster, UserDTOLeaf user) {
		this(id, active, createdAt);
		this.name = name;
		this.ram = ram;
		this.storage = storage;
		this.url = url;
		this.status = status;
		this.cluster = cluster;
		this.user = user;
	}

	public NodeDTO(Long id, Boolean active, LocalDateTime createdAt, String name, Long ram, Long storage, String url,
			NodeStatusEnum status, ClusterDTOLeaf cluster, UserDTOLeaf user, List<ContainerDTOLeaf> containers) {
		this(id, active, createdAt);
		this.name = name;
		this.ram = ram;
		this.storage = storage;
		this.url = url;
		this.status = status;
		this.cluster = cluster;
		this.user = user;
		this.containers = containers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRam() {
		return ram;
	}

	public void setRam(Long ram) {
		this.ram = ram;
	}

	public Long getStorage() {
		return storage;
	}

	public void setStorage(Long storage) {
		this.storage = storage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public NodeStatusEnum getStatus() {
		return status;
	}

	public void setStatus(NodeStatusEnum status) {
		this.status = status;
	}

	public ClusterDTOLeaf getCluster() {
		return cluster;
	}

	public void setCluster(ClusterDTOLeaf cluster) {
		this.cluster = cluster;
	}

	public UserDTOLeaf getUser() {
		return user;
	}

	public void setUser(UserDTOLeaf user) {
		this.user = user;
	}

	public List<ContainerDTOLeaf> getContainers() {
		return containers;
	}

	public void setContainers(List<ContainerDTOLeaf> containers) {
		this.containers = containers;
	}

}
