package rs.ac.singidunum.novisad.isaproject2023270048.dtos.image;

import java.time.LocalDateTime;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.BaseDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.models.ImageModel;

public class ImageDTOLeaf extends BaseDTO<ImageModel> {

	private String name;
	private Long requiredRam = 0l;
	private Long requiredStorage = 0l;
	private String url;
	private Long version = 1l;

	public ImageDTOLeaf() {
		super();
	}

	public ImageDTOLeaf(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

	public ImageDTOLeaf(String name, Long requiredRam, Long requiredStorage, String url, Long version) {
		this();
		this.name = name;
		this.requiredRam = requiredRam;
		this.requiredStorage = requiredStorage;
		this.url = url;
		this.version = version;
	}

	public ImageDTOLeaf(Long id, Boolean active, LocalDateTime createdAt, String name, Long requiredRam,
			Long requiredStorage, String url, Long version) {
		this(id, active, createdAt);
		this.name = name;
		this.requiredRam = requiredRam;
		this.requiredStorage = requiredStorage;
		this.url = url;
		this.version = version;
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

}
