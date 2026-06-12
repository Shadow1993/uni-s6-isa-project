package rs.ac.singidunum.novisad.isaproject2023270048.dtos.node;

import java.time.LocalDateTime;

import rs.ac.singidunum.novisad.isaproject2023270048.dtos.BaseDTO;
import rs.ac.singidunum.novisad.isaproject2023270048.models.NodeModel;
import rs.ac.singidunum.novisad.isaproject2023270048.models.NodeStatusEnum;

public class NodeDTOLeaf extends BaseDTO<NodeModel> {

	private String name;
	private Long ram = 0l;
	private Long storage = 0l;
	private String url;
	private NodeStatusEnum status;

	public NodeDTOLeaf() {
		super();
	}

	public NodeDTOLeaf(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

	public NodeDTOLeaf(String name, Long ram, Long storage, String url, NodeStatusEnum status) {
		this();
		this.name = name;
		this.ram = ram;
		this.storage = storage;
		this.url = url;
		this.status = status;
	}

	public NodeDTOLeaf(Long id, Boolean active, LocalDateTime createdAt, String name, Long ram, Long storage,
			String url, NodeStatusEnum status) {
		this(id, active, createdAt);
		this.name = name;
		this.ram = ram;
		this.storage = storage;
		this.url = url;
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

}
