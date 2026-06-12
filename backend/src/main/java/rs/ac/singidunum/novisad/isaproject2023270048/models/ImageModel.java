package rs.ac.singidunum.novisad.isaproject2023270048.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "image")
public class ImageModel extends BaseModel {

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Long requiredRam = 0l;

	@Column(nullable = false)
	private Long requiredStorage = 0l;

	@Column(nullable = false)
	private String url;

	@Column(nullable = false)
	private Long version = 1l;

	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private UserModel user;

	@OneToMany(mappedBy = "image")
	private List<ContainerModel> containers = new ArrayList<ContainerModel>();

	public ImageModel() {
		super();
	}

	public ImageModel(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

	public ImageModel(String name, Long requiredRam, Long requiredStorage, String url, Long version, UserModel user) {
		this();
		this.name = name;
		this.requiredRam = requiredRam;
		this.requiredStorage = requiredStorage;
		this.url = url;
		this.version = version;
		this.user = user;
	}

	public ImageModel(String name, Long requiredRam, Long requiredStorage, String url, Long version, UserModel user,
			List<ContainerModel> containers) {
		this();
		this.name = name;
		this.requiredRam = requiredRam;
		this.requiredStorage = requiredStorage;
		this.url = url;
		this.version = version;
		this.user = user;
		this.containers = containers;
	}

	public ImageModel(Long id, Boolean active, LocalDateTime createdAt, String name, Long requiredRam,
			Long requiredStorage, String url, Long version, UserModel user) {
		this(id, active, createdAt);
		this.name = name;
		this.requiredRam = requiredRam;
		this.requiredStorage = requiredStorage;
		this.url = url;
		this.version = version;
		this.user = user;
	}

	public ImageModel(Long id, Boolean active, LocalDateTime createdAt, String name, Long requiredRam,
			Long requiredStorage, String url, Long version, UserModel user, List<ContainerModel> containers) {
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
