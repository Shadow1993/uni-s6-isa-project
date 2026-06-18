package rs.ac.singidunum.novisad.isaproject2023270048.dtos.container;

public class ContainerCreateDTO {
	private String name;
	private Long clusterId;
	private Long imageId;

	public ContainerCreateDTO() {
		super();
	}

	public ContainerCreateDTO(String name, Long clusterId, Long imageId) {
		super();
		this.name = name;
		this.clusterId = clusterId;
		this.imageId = imageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getClusterId() {
		return clusterId;
	}

	public void setClusterId(Long clusterId) {
		this.clusterId = clusterId;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

}
