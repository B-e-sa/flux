package project.flux.api.v1.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.flux.api.v1.models.Carrier;
import project.flux.api.v1.models.dtos.CarrierDTO;
import project.flux.api.v1.repositories.CarrierRepository;

@Service
public class CarrierService {
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	CarrierRepository carrierRepository;
	
	public List<Carrier> findAll() {
		return carrierRepository.findAll(); 
	}
	
	public void create(CarrierDTO carrier) { 
		carrierRepository.save(
				modelMapper.map(carrier, Carrier.class)); 
	}
}
