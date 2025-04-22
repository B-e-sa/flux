package project.flux.api.v1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.flux.api.v1.models.common.DatabaseEntity;
import project.flux.api.v1.models.common.enums.AddressType;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address extends DatabaseEntity {
	@Column(nullable = false)
	private String country;
	
	private String cep;
	private String neighborhood;
	private String street;
	private String number;
	private String reference;
	private AddressType type;
	
	@ManyToOne
    @JoinColumn(name="address_id", nullable=false)
	private Recipient recipient;
}
