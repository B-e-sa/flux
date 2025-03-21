package project.flux.api.v1.services.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import project.flux.api.v1.models.common.decorators.EnumValidator;
import project.flux.api.v1.models.common.enums.DeliveryType;

@Getter
@AllArgsConstructor
public class CarrierDTO {
	private long id;
	
	@NotNull
	private String name;
	
	private double baseTax;
	
	@NotNull
	@EnumValidator(enumClass = DeliveryType.class)
	private String deliveryType;
	
	public CarrierDTO() {}
	
	public CarrierDTO(long id, 
			String name, 
			String deliveryType, 
			double baseTax) {
		this.id = id;
		this.name = name;
		this.deliveryType = deliveryType;
		this.baseTax = baseTax;
	}
}
