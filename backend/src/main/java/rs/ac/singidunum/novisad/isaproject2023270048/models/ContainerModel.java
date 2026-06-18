package rs.ac.singidunum.novisad.isaproject2023270048.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "container")
public class ContainerModel extends BaseModel {

	@Column(nullable = false)
	private String name;

	@Column(name = "started_at")
	private LocalDateTime startedAt;

	@Column(name = "stopped_at")
	private LocalDateTime stoppedAt;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ContainerStatusEnum status = ContainerStatusEnum.STOPPED;

	@ManyToOne(optional = false)
	@JoinColumn(name = "image_id")
	private ImageModel image;

	@ManyToOne(optional = false)
	@JoinColumn(name = "node_id")
	private NodeModel node;

	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private UserModel user;

	public ContainerModel() {
		super();
	}

	public ContainerModel(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

	public ContainerModel(String name, LocalDateTime startedAt, LocalDateTime stoppedAt, ContainerStatusEnum status,
			ImageModel image, NodeModel node, UserModel user) {
		this();
		this.name = name;
		this.startedAt = startedAt;
		this.stoppedAt = stoppedAt;
		this.status = status;
		this.image = image;
		this.node = node;
		this.user = user;
	}

	public ContainerModel(Long id, Boolean active, LocalDateTime createdAt, String name, LocalDateTime startedAt,
			LocalDateTime stoppedAt, ContainerStatusEnum status, ImageModel image, NodeModel node, UserModel user) {
		this(id, active, createdAt);
		this.name = name;
		this.startedAt = startedAt;
		this.stoppedAt = stoppedAt;
		this.status = status;
		this.image = image;
		this.node = node;
		this.user = user;
	}
	
	public ContainerModel(String name, ImageModel image, NodeModel node, UserModel user) {
		this();
		this.name = name;
		this.image = image;
		this.node = node;
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(LocalDateTime startedAt) {
		this.startedAt = startedAt;
	}

	public LocalDateTime getStoppedAt() {
		return stoppedAt;
	}

	public void setStoppedAt(LocalDateTime stoppedAt) {
		this.stoppedAt = stoppedAt;
	}

	public ContainerStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ContainerStatusEnum status) {
		this.status = status;
	}

	public ImageModel getImage() {
		return image;
	}

	public void setImage(ImageModel image) {
		this.image = image;
	}

	public NodeModel getNode() {
		return node;
	}

	public void setNode(NodeModel node) {
		this.node = node;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

}
