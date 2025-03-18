package project.flux.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import project.flux.api.v1.models.Carrier;
import project.flux.api.v1.models.dtos.CarrierDTO;
import project.flux.api.v1.services.CarrierService;

@RestController
@RequestMapping("/carriers")
public class CarrierController {
	@Autowired
	CarrierService carrierService;
	
	@GetMapping
	public ResponseEntity<List<Carrier>> getCarriers() {
		return new ResponseEntity<>(carrierService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<HttpStatus> createCarrier(
			@Valid @RequestBody CarrierDTO carrier) {
		carrierService.create(carrier);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
