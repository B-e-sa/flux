package project.flux.api.v1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import project.flux.api.v1.controllers.common.Validator;
import project.flux.api.v1.controllers.common.exceptions.NotFoundException;
import project.flux.api.v1.models.Recipient;
import project.flux.api.v1.services.AddressService;
import project.flux.api.v1.services.RecipientService;
import project.flux.api.v1.services.dtos.AddressDTO;
import project.flux.api.v1.services.dtos.RecipientDTO;
import project.flux.api.v1.services.dtos.requests.CreateRecipientRequest;

@RestController
@RequestMapping("/recipient")
public class RecipientController {
	@Autowired
	private RecipientService recipientService;
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping
	public ResponseEntity<RecipientDTO> findById(@PathVariable("id") String id) {
		long idLong = Validator.id(id);
		RecipientDTO foundRecipient = recipientService.findById(idLong);
		return new ResponseEntity<>(foundRecipient, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<HttpStatus> register(@Valid @RequestBody CreateRecipientRequest request) {
	    Recipient recipient = recipientService.register(request.getRecipient());

	    if (request.getAddresses() != null)
            for (AddressDTO addressDTO : request.getAddresses())
                addressService.create(addressDTO, recipient);
		
	    return new ResponseEntity<>(HttpStatus.OK);
	}
}
