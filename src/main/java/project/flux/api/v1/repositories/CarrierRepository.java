package project.flux.api.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.flux.api.v1.models.Carrier;

@Repository
public interface CarrierRepository extends JpaRepository<Carrier, Integer> {
	Carrier findByName(String name);
}
