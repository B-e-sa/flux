package project.flux.api.v1.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import project.flux.api.v1.models.common.DatabaseEntity;

@Entity
@Getter
@Setter
public class Carrier extends DatabaseEntity {
	private String name;
	
	public Carrier(String name) {
		this.name = name;
	}
}
