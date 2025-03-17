package project.flux.api.v1.models.common;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
public class DatabaseEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id private long id;
	
	@Getter
	private Date createdAt;
	
	public DatabaseEntity() { this.createdAt = new Date(); }
}
