package project.flux.api.v1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import project.flux.api.v1.controllers.common.Validator;
import project.flux.api.v1.dtos.AddressDTO;
import project.flux.api.v1.dtos.requests.CreateAddressRequest;
import project.flux.api.v1.models.Address;
import project.flux.api.v1.models.Recipient;
import project.flux.api.v1.services.AddressService;
import project.flux.api.v1.services.RecipientService;

@RestController
@RequestMapping("/addresses")
public class AddressController {
	@Autowired
	AddressService addressService;
	
	@Autowired
	RecipientService recipientService;
	
	@PostMapping
	public ResponseEntity<HttpStatus> createAddress(@Valid @RequestBody CreateAddressRequest request) {
		Recipient recipient = recipientService.findById(request.getRecipientId());
		addressService.create(request.getAdress(), recipient);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<AddressDTO> findAddress(@PathVariable("id") String id) {
		Address address = addressService.findById(Validator.id(id));
		return new ResponseEntity<AddressDTO>(new AddressDTO().parse(address), HttpStatus.OK);
	}
	
	@PutMapping("edit/{id}")
	public ResponseEntity<HttpStatus> editAddress(
			@PathVariable("id") String id, @RequestBody AddressDTO address) {
		addressService.edit(Validator.id(id), address);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
