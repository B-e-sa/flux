package project.flux.api.v1.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.flux.api.v1.models.Address;
import project.flux.api.v1.models.Recipient;
import project.flux.api.v1.models.common.enums.AddressType;
import project.flux.api.v1.utils.EnumParser;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RecipientDTO extends DTOBase<RecipientDTO, Recipient> {
	private long id;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;

	@NotNull
	private String cpf;
	
	@NotNull
	@Email
	private String email;

	@Override
	public RecipientDTO parse(Recipient recipient) {
		return new RecipientDTO(
				recipient.getId(),
				recipient.getFirstName(),
				recipient.getLastName(),
				recipient.getCpf(),
				recipient.getEmail());
	}

	@Override
	public Recipient format() {
		return new Recipient(
				null, 
				this.getFirstName(),
				this.getLastName(),
				this.getCpf(),
				this.getEmail());
	}
}
