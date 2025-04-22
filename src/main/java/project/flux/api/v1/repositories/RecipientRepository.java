package project.flux.api.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.flux.api.v1.models.Recipient;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Long> {
	boolean existsByCpf(String cpf);
	boolean existsByEmail(String email);
}