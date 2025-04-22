package project.flux.api.v1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import project.flux.api.v1.models.common.DatabaseEntity;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Recipient extends DatabaseEntity {
	@OneToMany(mappedBy = "recipient")
	@Column(nullable = false)
	private List<Address> address;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(unique = true)
	private String cpf;
	
	@Column(nullable = false, unique = true)
	private String email;
}