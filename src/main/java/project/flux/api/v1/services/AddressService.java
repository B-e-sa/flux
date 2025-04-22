package project.flux.api.v1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.flux.api.v1.controllers.common.exceptions.NotFoundException;
import project.flux.api.v1.dtos.AddressDTO;
import project.flux.api.v1.models.Address;
import project.flux.api.v1.models.Recipient;
import project.flux.api.v1.models.common.enums.AddressType;
import project.flux.api.v1.repositories.AddressRepository;
import project.flux.api.v1.services.common.Mapper;
import project.flux.api.v1.utils.EnumParser;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	public Address edit(long id, AddressDTO address) {
		Address foundAddress = addressRepository
				.findById(id)
				.orElseThrow(() -> new NotFoundException());
		
		Mapper.updateIfChanged(foundAddress::setCep,
				foundAddress.getCep(),
				address.getCep());
		
		Mapper.updateIfNullableChanged(foundAddress::setCountry, 
				foundAddress.getCountry(),
				address.getCountry());
		
		Mapper.updateIfChanged(foundAddress::setNeighborhood, 
				foundAddress.getNeighborhood(),
				address.getNeighborhood());
		
		Mapper.updateIfChanged(foundAddress::setStreet, 
				foundAddress.getStreet(),
				address.getStreet());
		
		Mapper.updateIfChanged(foundAddress::setReference, 
				foundAddress.getReference(),
				address.getReference());
		
		Mapper.updateIfChanged(foundAddress::setNumber, 
				foundAddress.getNumber(),
				address.getNumber());
		
		AddressType validDeliveryType = 
	    		EnumParser.fromString(address.getType(), AddressType.class);
		
		Mapper.<AddressType>updateIfChanged(foundAddress::setType, 
				foundAddress.getType(),
				validDeliveryType);
		
		return addressRepository.save(foundAddress);
	}
	
	public Address findById(long id) {
		Address foundAddress = addressRepository
				.findById(id)
				.orElseThrow(() -> new NotFoundException());
		return foundAddress;
	}
	
	public void create(AddressDTO address, Recipient recipient) {
		Address formatedAddress = address.format();
		formatedAddress.setRecipient(recipient);
		addressRepository.save(formatedAddress);
	}
}
