package project.flux.api.v1.models;

import lombok.Getter;
import project.flux.api.v1.models.common.DatabaseEntity;
import project.flux.api.v1.models.enums.AddressType;

@Getter
public class Address extends DatabaseEntity {
	private String cep;
	private String country;
	private String neighborhood;
	private String street;
	private String number;
	private String reference;
	private AddressType type;
}
