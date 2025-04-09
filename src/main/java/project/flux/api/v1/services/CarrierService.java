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
import project.flux.api.v1.services.dtos.CarrierDTO;
import project.flux.api.v1.utils.EnumParser;

@Service
public class CarrierService {
	@Autowired
	CarrierRepository carrierRepository;
	
	public List<CarrierDTO> findAll() {
		return carrierRepository
				.findAll()
				.stream()
                .map(carrier -> new CarrierDTO(
                		carrier.getName(),
                		carrier.getDeliveryType().toString(),
                		carrier.getBaseTax()))
                .collect(Collectors.toList());
	}
	
	public CarrierDTO findById(long id) {
		 Carrier carrier = carrierRepository
				 .findById(id)
				 .orElseThrow(() -> new NotFoundException());
		 
		 return new CarrierDTO(
				 carrier.getName(),
				 carrier.getDeliveryType().toString(),
				 carrier.getBaseTax());
	}
	
	public void edit(long id, CarrierDTO carrier) {
		Carrier foundCarrier = carrierRepository
				.findById(id)
				.orElseThrow(() -> new NotFoundException());
		
		if (carrier.getName() != null && 
				!carrier.getName().equals(foundCarrier.getName()))
			foundCarrier.setName(carrier.getName());
		
		if (carrier.getBaseTax() != 0 && 
				carrier.getBaseTax() != foundCarrier.getBaseTax())
			foundCarrier.setBaseTax(carrier.getBaseTax());
		
		
		if (carrier.getDeliveryType() != null && 
				!carrier
				.getDeliveryType()
				.equals(foundCarrier.getDeliveryType().toString())) {
			DeliveryType validDeliveryType = 
		    		EnumParser.fromString(carrier.getDeliveryType(), DeliveryType.class);
			
			foundCarrier.setDeliveryType(validDeliveryType);
		}
		
		carrierRepository.save(foundCarrier);
	}
	
	public void delete(long id) {
		Carrier foundCarrier = carrierRepository
				.findById(id)
				.orElseThrow(() -> new NotFoundException());
		
		carrierRepository.delete(foundCarrier);
	}
	
	public CarrierDTO findByName(String name) throws NotFoundException {
		Carrier foundCarrier = carrierRepository.findByName(name);
		
		if (foundCarrier == null)
			throw new NotFoundException();
			
		return new CarrierDTO(
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
