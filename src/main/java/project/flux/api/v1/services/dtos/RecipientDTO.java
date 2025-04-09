package project.flux.api.v1.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RecipientDTO {
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;

	@NotNull
	private String cpf;
	
	@NotNull
	@Email
	private String email;
}
