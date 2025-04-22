package project.flux.api.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.flux.api.v1.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {}
