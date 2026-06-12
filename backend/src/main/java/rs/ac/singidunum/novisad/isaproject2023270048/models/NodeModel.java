package rs.ac.singidunum.novisad.isaproject2023270048.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "node")
public class NodeModel extends BaseModel {

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Long ram = 0l;

	@Column(nullable = false)
	private Long storage = 0l;

	@Column(nullable = false)
	private String url;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private NodeStatusEnum status;

	@ManyToOne(optional = false)
	@JoinColumn(name = "cluster_id")
	private ClusterModel cluster;

	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private UserModel user;

	@OneToMany(mappedBy = "node")
	private List<ContainerModel> containers = new ArrayList<ContainerModel>();

	public NodeModel() {
		super();
	}

	public NodeModel(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

	public NodeModel(String name, Long ram, Long storage, String url, NodeStatusEnum status, ClusterModel cluster,
			UserModel user) {
		this();
		this.name = name;
		this.ram = ram;
		this.storage = storage;
		this.url = url;
		this.status = status;
		this.cluster = cluster;
		this.user = user;
	}

	public NodeModel(String name, Long ram, Long storage, String url, NodeStatusEnum status, ClusterModel cluster,
			UserModel user, List<ContainerModel> containers) {
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

	public NodeModel(Long id, Boolean active, LocalDateTime createdAt, String name, Long ram, Long storage, String url,
			NodeStatusEnum status, ClusterModel cluster, UserModel user) {
		this(id, active, createdAt);
		this.name = name;
		this.ram = ram;
		this.storage = storage;
		this.url = url;
		this.status = status;
		this.cluster = cluster;
		this.user = user;
	}

	public NodeModel(Long id, Boolean active, LocalDateTime createdAt, String name, Long ram, Long storage, String url,
			NodeStatusEnum status, ClusterModel cluster, UserModel user, List<ContainerModel> containers) {
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

	public ClusterModel getCluster() {
		return cluster;
	}

	public void setCluster(ClusterModel cluster) {
		this.cluster = cluster;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public List<ContainerModel> getContainers() {
		return containers;
	}

	public void setContainers(List<ContainerModel> containers) {
		this.containers = containers;
	}

}
