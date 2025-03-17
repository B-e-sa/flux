package project.flux.api.v1.models;

import lombok.Getter;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import project.flux.api.v1.models.common.DatabaseEntity;

@Getter
public class Recipient extends DatabaseEntity {
	@OneToMany
	@Column(nullable = false)
	private List<Address> address;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(unique = true)
	private String cpf;
	
	@Column(nullable = false, unique = true)
	private String email;
}