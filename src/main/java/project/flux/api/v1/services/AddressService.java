package project.flux.api.v1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.flux.api.v1.models.Address;
import project.flux.api.v1.models.Recipient;
import project.flux.api.v1.models.common.enums.AddressType;
import project.flux.api.v1.models.common.enums.DeliveryType;
import project.flux.api.v1.repositories.AddressRepository;
import project.flux.api.v1.services.dtos.AddressDTO;
import project.flux.api.v1.utils.EnumParser;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	public Address create(AddressDTO address, Recipient recipient) {
		AddressType validAddressType = 
	    		EnumParser.fromString(address.getType(), AddressType.class);
		
		return addressRepository.save(new Address(
				address.getCountry(), 
				address.getCep(), 
				address.getNeighborhood(), 
				address.getStreet(), 
				address.getNumber(), 
				address.getReference(), 
				validAddressType, 
				recipient));
	}
}
