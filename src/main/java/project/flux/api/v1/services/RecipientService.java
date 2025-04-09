package project.flux.api.v1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.flux.api.v1.controllers.common.exceptions.ConflictException;
import project.flux.api.v1.controllers.common.exceptions.NotFoundException;
import project.flux.api.v1.models.Recipient;
import project.flux.api.v1.repositories.RecipientRepository;
import project.flux.api.v1.services.dtos.RecipientDTO;

@Service
public class RecipientService {
	@Autowired
	RecipientRepository recipientRepository; 
	
	public RecipientDTO findById(long id) {
		Recipient foundRecipient = recipientRepository
				.findById(id)
				.orElseThrow(() -> new NotFoundException());
		
		return new RecipientDTO(
				foundRecipient.getFirstName(),
				foundRecipient.getLastName(),
				foundRecipient.getCpf(),
				foundRecipient.getEmail());
	}
	
	public Recipient register(RecipientDTO recipient) {	
		if (recipientRepository.existsByCpf(recipient.getCpf()))
			throw new ConflictException("An user with this CPF already exists");
			
		if (recipientRepository.existsByEmail(recipient.getEmail()))
			throw new ConflictException("An user with this email already exisits");
		
		return recipientRepository.save(new Recipient(
	    		null, 
	    		recipient.getFirstName(),
	    		recipient.getLastName(),
	    		recipient.getCpf(),
	    		recipient.getEmail()));
	}
}
