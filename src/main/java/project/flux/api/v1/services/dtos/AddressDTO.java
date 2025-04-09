package project.flux.api.v1.services.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.flux.api.v1.models.common.decorators.EnumValidator;
import project.flux.api.v1.models.common.enums.AddressType;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
	@NotNull
	private String country;
	private String cep;
	private String neighborhood;
	private String street;
	private String number;
	private String reference;
	
	@EnumValidator(enumClass = AddressType.class)
	private String type;
}
