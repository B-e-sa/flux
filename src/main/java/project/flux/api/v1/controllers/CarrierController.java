package project.flux.api.v1.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import project.flux.api.v1.controllers.common.Validator;
import project.flux.api.v1.controllers.common.exceptions.BadRequestException;
import project.flux.api.v1.controllers.common.exceptions.NotFoundException;
import project.flux.api.v1.dtos.CarrierDTO;
import project.flux.api.v1.services.CarrierService;

@RestController
@RequestMapping("/carriers")
public class CarrierController {
	@Autowired
	private CarrierService carrierService;
	
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") String id) throws BadRequestException {
		long idLong = Validator.id(id);
		carrierService.delete(idLong);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("edit/{id}")
	public ResponseEntity<HttpStatus> editCarrier(
			@PathVariable("id") String id, @RequestBody CarrierDTO carrier) throws BadRequestException {
		long idLong = Validator.id(id);
		carrierService.edit(idLong, carrier);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<CarrierDTO> findById(@PathVariable("id") String id) throws NotFoundException {
		long idLong = Validator.id(id);
		CarrierDTO foundCarrier = carrierService.findById(idLong);
		return new ResponseEntity<>(foundCarrier, HttpStatus.OK);
	}
	
	@GetMapping("/by-name/{name}")
	public ResponseEntity<CarrierDTO> findByName(@PathVariable("name") String name) throws NotFoundException {
		CarrierDTO foundCarrier = carrierService.findByName(name);
		return new ResponseEntity<>(foundCarrier, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<CarrierDTO>> findAll() {
		List<CarrierDTO> carriers = carrierService.findAll()
				.stream()
                .map(carrier -> new CarrierDTO(
                		carrier.getName(),
                		carrier.getDeliveryType().toString(),
                		carrier.getBaseTax()))
                .collect(Collectors.toList());
		
		return new ResponseEntity<>(carriers, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<HttpStatus> create(@Valid @RequestBody CarrierDTO carrier) throws NotFoundException {
		carrierService.create(carrier);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
