package rs.ac.singidunum.novisad.isaproject2023270048.dtos.container;

import java.time.LocalDateTime;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.BaseDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ContainerModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ContainerStatusEnum;

public class ContainerDTOLeaf extends BaseDTO<ContainerModel> {

	private String name;
	private LocalDateTime startedAt;
	private LocalDateTime stoppedAt;
	private ContainerStatusEnum status;

	public ContainerDTOLeaf() {
		super();
	}

	public ContainerDTOLeaf(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

	public ContainerDTOLeaf(String name, LocalDateTime startedAt, LocalDateTime stoppedAt, ContainerStatusEnum status) {
		this();
		this.name = name;
		this.startedAt = startedAt;
		this.stoppedAt = stoppedAt;
		this.status = status;
	}

	public ContainerDTOLeaf(Long id, Boolean active, LocalDateTime createdAt, String name, LocalDateTime startedAt,
			LocalDateTime stoppedAt, ContainerStatusEnum status) {
		this(id, active, createdAt);
		this.name = name;
		this.startedAt = startedAt;
		this.stoppedAt = stoppedAt;
		this.status = status;
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

}
