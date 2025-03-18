package project.flux.api.v1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import project.flux.api.v1.models.common.DatabaseEntity;
import project.flux.api.v1.models.common.enums.AddressType;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Address extends DatabaseEntity {
	private String cep;
	
	@Column(nullable = false)
	private String country;
	
	@Column(nullable = false)
	private String neighborhood;
	
	private String street;
	private String number;
	private String reference;
	private AddressType type;
}
