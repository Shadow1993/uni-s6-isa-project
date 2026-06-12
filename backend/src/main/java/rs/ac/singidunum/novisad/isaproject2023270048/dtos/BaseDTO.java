package rs.ac.singidunum.novisad.isaproject2023270048.dtos;

import java.time.LocalDateTime;

public abstract class BaseDTO<T> {
	
	private Long id;
	private Boolean active = false;
	private LocalDateTime createdAt;
	
	public BaseDTO() {
		super();
	}

	public BaseDTO(Long id, Boolean active, LocalDateTime createdAt) {
		this();
		this.id = id;
		this.active = active;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
}