package rs.ac.singidunum.novisad.isaproject2023270048.dtos.image;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.BaseDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.container.ContainerDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.dtos.user.UserDTOLeaf;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ImageModel;

public class ImageDTO extends BaseDTO<ImageModel> {

	private String name;
	private Long requiredRam = 0l;
	private Long requiredStorage = 0l;
	private String url;
	private Long version = 1l;
	private UserDTOLeaf user;
	private List<ContainerDTOLeaf> containers = new ArrayList<ContainerDTOLeaf>();

	public ImageDTO() {
		super();
	}

	public ImageDTO(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

	public ImageDTO(String name, Long requiredRam, Long requiredStorage, String url, Long version, UserDTOLeaf user) {
		this();
		this.name = name;
		this.requiredRam = requiredRam;
		this.requiredStorage = requiredStorage;
		this.url = url;
		this.version = version;
		this.user = user;
	}

	public ImageDTO(String name, Long requiredRam, Long requiredStorage, String url, Long version, UserDTOLeaf user,
			List<ContainerDTOLeaf> containers) {
		this();
		this.name = name;
		this.requiredRam = requiredRam;
		this.requiredStorage = requiredStorage;
		this.url = url;
		this.version = version;
		this.user = user;
		this.containers = containers;
	}

	public ImageDTO(Long id, Boolean active, LocalDateTime createdAt, String name, Long requiredRam,
			Long requiredStorage, String url, Long version, UserDTOLeaf user) {
		this(id, active, createdAt);
		this.name = name;
		this.requiredRam = requiredRam;
		this.requiredStorage = requiredStorage;
		this.url = url;
		this.version = version;
		this.user = user;
	}

	public ImageDTO(Long id, Boolean active, LocalDateTime createdAt, String name, Long requiredRam,
			Long requiredStorage, String url, Long version, UserDTOLeaf user, List<ContainerDTOLeaf> containers) {
		this(id, active, createdAt);
		this.name = name;
		this.requiredRam = requiredRam;
		this.requiredStorage = requiredStorage;
		this.url = url;
		this.version = version;
		this.user = user;
		this.containers = containers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRequiredRam() {
		return requiredRam;
	}

	public void setRequiredRam(Long requiredRam) {
		this.requiredRam = requiredRam;
	}

	public Long getRequiredStorage() {
		return requiredStorage;
	}

	public void setRequiredStorage(Long requiredStorage) {
		this.requiredStorage = requiredStorage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
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
