package project.flux.api.v1.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.flux.api.v1.models.Address;
import project.flux.api.v1.models.Recipient;
import project.flux.api.v1.models.common.decorators.EnumValidator;
import project.flux.api.v1.models.common.enums.AddressType;
import project.flux.api.v1.utils.EnumParser;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO extends DTOBase<AddressDTO, Address> {
	private long id;
	
	@NotNull
	private String country;
	private String cep;
	private String neighborhood;
	private String street;
	private String number;
	private String reference;
	
	@EnumValidator(enumClass = AddressType.class)
	private String type;
	
	@Override
	public AddressDTO parse(Address address) {
		return new AddressDTO(
				address.getId(),
				address.getCountry(),
				address.getCep(),
				address.getNeighborhood(),
				address.getStreet(),
				address.getNumber(),
				address.getReference(),
				address.getType().toString());
	}

	@Override
	public Address format() {
		return new Address(
				this.country,
				this.cep,
				this.neighborhood,
				this.street,
				this.number,
				this.reference,
				EnumParser.fromString(this.type, AddressType.class), 
				null);
	}
}
