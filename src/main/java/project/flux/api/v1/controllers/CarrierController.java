package project.flux.api.v1.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import project.flux.api.v1.controllers.common.LongParser;
import project.flux.api.v1.controllers.common.exceptions.BadRequestException;
import project.flux.api.v1.controllers.common.exceptions.NotFoundException;
import project.flux.api.v1.services.CarrierService;
import project.flux.api.v1.services.dtos.CarrierDTO;

@RestController
@RequestMapping("/carriers")
public class CarrierController {
	@Autowired
	CarrierService carrierService;
	
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> delete(
			@PathVariable("id") String id) throws BadRequestException {
		long idLong = LongParser.fromString(id);
		
		if (idLong == -1)
			throw new BadRequestException("Invalid id format");
		
		carrierService.deleteCarrier(idLong);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("{name}")
	public ResponseEntity<CarrierDTO> findByName(
			@PathVariable("name") String name) throws NotFoundException {		
		CarrierDTO foundCarrier = carrierService.findByName(name);
		return new ResponseEntity<>(foundCarrier, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<CarrierDTO>> findAll() {
		return new ResponseEntity<>(carrierService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<HttpStatus> create(
			@Valid @RequestBody CarrierDTO carrier) throws NotFoundException {			
		carrierService.create(carrier);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
