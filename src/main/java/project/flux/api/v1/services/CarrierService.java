package project.flux.api.v1.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.flux.api.v1.controllers.common.exceptions.ConflictException;
import project.flux.api.v1.controllers.common.exceptions.NotFoundException;
import project.flux.api.v1.models.Carrier;
import project.flux.api.v1.models.common.enums.DeliveryType;
import project.flux.api.v1.repositories.CarrierRepository;
import project.flux.api.v1.services.common.EnumParser;
import project.flux.api.v1.services.dtos.CarrierDTO;

@Service
public class CarrierService {
	@Autowired
	CarrierRepository carrierRepository;
	
	public List<CarrierDTO> findAll() {
		return carrierRepository
				.findAll()
				.stream()
                .map(carrier -> new CarrierDTO(
                		carrier.getId(),
                		carrier.getName(),
                		carrier.getDeliveryType().toString(),
                		carrier.getBaseTax()))
                .collect(Collectors.toList());
	}
	
	/*
	public CarrierDTO findById(int id) {
		 Optional<Carrier> foundCarrier = carrierRepository.findById(id);
		 
		 if (foundCarrier.isPresent() != true)
			 return null;
		 
		 Carrier carrier = foundCarrier.get();
		 
		 return new CarrierDTO(carrier.getName(), 
				 carrier.getDeliveryType().toString(),
				 carrier.getBaseTax());
	}
	*/
	
	public void deleteCarrier(long id) {
		Optional<Carrier> foundCarrier = carrierRepository.findById(id);
		
		if (foundCarrier.isPresent() == false)
			throw new NotFoundException();
		
		carrierRepository.delete(foundCarrier.get());
	}
	
	public CarrierDTO findByName(String name) throws NotFoundException {
		Carrier foundCarrier = carrierRepository.findByName(name);
		
		if (foundCarrier == null)
			throw new NotFoundException();
			
		return new CarrierDTO(
				foundCarrier.getId(),
				foundCarrier.getName(), 
				foundCarrier.getDeliveryType().toString(),
				foundCarrier.getBaseTax());
	}
	
	public void create(CarrierDTO carrier) throws NotFoundException { 
		Carrier existentCarrier = carrierRepository.findByName(carrier.getName());
		
		if (existentCarrier != null)
			throw new ConflictException(
					"A carrier with the same name already exists");
		
	    DeliveryType validDeliveryType = 
	    		EnumParser.fromString(carrier.getDeliveryType(), DeliveryType.class);
		
		carrierRepository.save(
				new Carrier(carrier.getName(), 
						validDeliveryType,
						carrier.getBaseTax())); 
	}
}
