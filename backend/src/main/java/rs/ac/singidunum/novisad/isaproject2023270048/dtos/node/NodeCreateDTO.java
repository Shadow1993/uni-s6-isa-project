package rs.ac.singidunum.novisad.isaproject2023270048.dtos.node;

public class NodeCreateDTO {
	
	private String name;
	private long ram = 0l;
	private long storage = 0l;
	private String url;
	private Long clusterId;
	
	public NodeCreateDTO() {
		super();
	}

	public NodeCreateDTO(String name, long ram, long storage, String url, Long clusterId) {
		super();
		this.name = name;
		this.ram = ram;
		this.storage = storage;
		this.url = url;
		this.clusterId = clusterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getRam() {
		return ram;
	}

	public void setRam(long ram) {
		this.ram = ram;
	}

	public long getStorage() {
		return storage;
	}

	public void setStorage(long storage) {
		this.storage = storage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getClusterId() {
		return clusterId;
	}

	public void setClusterId(Long clusterId) {
		this.clusterId = clusterId;
	}

}
