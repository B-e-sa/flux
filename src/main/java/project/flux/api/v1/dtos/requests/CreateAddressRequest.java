package project.flux.api.v1.dtos.requests;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.flux.api.v1.dtos.AddressDTO;

@NoArgsConstructor
@Getter
public class CreateAddressRequest {
	@Valid private AddressDTO adress;
	
	@JsonAlias("recipient_id")
	private long recipientId;
}
