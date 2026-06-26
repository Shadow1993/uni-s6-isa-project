package rs.ac.singidunum.novisad.isaproject2023270048.dtos.image;

public class ImageCreateDTO {

	private String name;
	private long requiredRam = 0l;
	private long requiredStorage = 0l;
	private String url;
	private long version = 1l;

	public ImageCreateDTO() {
		super();
	}

	public ImageCreateDTO(String name, long requiredRam, long requiredStorage, String url, long version) {
		super();
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

	public long getRequiredRam() {
		return requiredRam;
	}

	public void setRequiredRam(long requiredRam) {
		this.requiredRam = requiredRam;
	}

	public long getRequiredStorage() {
		return requiredStorage;
	}

	public void setRequiredStorage(long requiredStorage) {
		this.requiredStorage = requiredStorage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

}
