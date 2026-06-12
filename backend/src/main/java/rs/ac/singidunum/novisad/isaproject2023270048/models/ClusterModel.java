package rs.ac.singidunum.novisad.isaproject2023270048.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cluster")
public class ClusterModel extends BaseModel {
	
	@Column(nullable = false, unique = true)
	private String name;

	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private UserModel user;

	public ClusterModel() {
		super();
	}

	public ClusterModel(Long id, Boolean active, LocalDateTime createdAt) {
		super(id, active, createdAt);
	}

	public ClusterModel(String name, UserModel user) {
		this();
		this.name = name;
		this.user = user;
	}
	
	public ClusterModel(Long id, Boolean active, LocalDateTime createdAt, String name, UserModel user) {
		this(id, active, createdAt);
		this.name = name;
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
	
}
