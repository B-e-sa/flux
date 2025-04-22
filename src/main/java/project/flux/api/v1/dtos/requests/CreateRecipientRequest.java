package project.flux.api.v1.dtos.requests;

import java.util.List;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.flux.api.v1.dtos.AddressDTO;
import project.flux.api.v1.dtos.RecipientDTO;


@NoArgsConstructor
@Getter
public class CreateRecipientRequest {
	@Valid private RecipientDTO recipient;
	@Valid private List<AddressDTO> addresses;
}
