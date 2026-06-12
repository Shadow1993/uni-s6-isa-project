package rs.ac.singidunum.novisad.isaproject2023270048.dtos.container;

import java.time.LocalDateTime;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.BaseDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.image.ImageDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.node.NodeDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.user.UserDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ContainerModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ContainerStatusEnum;

public class ContainerDTO extends BaseDTO<ContainerModel> {

	private String name;
	private LocalDateTime startedAt;
	private LocalDateTime stoppedAt;
	private ContainerStatusEnum status;
	private ImageDTOLeaf image;
	private NodeDTOLeaf node;
	private UserDTOLeaf user;

	public ContainerDTO() {
		super();
	}

	public ContainerDTO(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

	public ContainerDTO(String name, LocalDateTime startedAt, LocalDateTime stoppedAt, ContainerStatusEnum status,
			ImageDTOLeaf image, NodeDTOLeaf node, UserDTOLeaf user) {
		this();
		this.name = name;
		this.startedAt = startedAt;
		this.stoppedAt = stoppedAt;
		this.status = status;
		this.image = image;
		this.node = node;
		this.user = user;
	}

	public ContainerDTO(Long id, Boolean active, LocalDateTime createdAt, String name, LocalDateTime startedAt,
			LocalDateTime stoppedAt, ContainerStatusEnum status, ImageDTOLeaf image, NodeDTOLeaf node,
			UserDTOLeaf user) {
		this(id, active, createdAt);
		this.name = name;
		this.startedAt = startedAt;
		this.stoppedAt = stoppedAt;
		this.status = status;
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

	public ImageDTOLeaf getImage() {
		return image;
	}

	public void setImage(ImageDTOLeaf image) {
		this.image = image;
	}

	public NodeDTOLeaf getNode() {
		return node;
	}

	public void setNode(NodeDTOLeaf node) {
		this.node = node;
	}

	public UserDTOLeaf getUser() {
		return user;
	}

	public void setUser(UserDTOLeaf user) {
		this.user = user;
	}

}
