package project.flux.api.v1.models.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import project.flux.api.v1.models.Carrier;

@Getter
public class CarrierDTO {
	@NotNull
	private String name;
	
	public CarrierDTO() {}
	
	public CarrierDTO(String name) {
		this.name = name;
	}
}
