package project.flux.api.v1.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import project.flux.api.v1.models.common.DatabaseEntity;
import project.flux.api.v1.models.common.enums.DeliveryStatus;
import project.flux.api.v1.models.common.enums.DeliveryType;

@Getter
@Setter
@AllArgsConstructor
public class Delivery extends DatabaseEntity {	
	@OneToOne
	@Column(nullable = false)
	private Carrier carrier;
	
	@OneToMany
	@Column(nullable = false)
	private Recipient recipient;

	@OneToOne
	@Column(name = "start_address", nullable = false)
	private Address startAddress;
	
	@OneToOne
	@Column(name = "final_address",nullable = false)
	private Address finalAddress;
	
	// @OneToOne
	// private long admin;
	
	@Column(name = "tracking_number", nullable = false, unique = true)
	private String trackingNumber;
	
	@Column(nullable = false)
	private Date deadline;
	
	@Column(nullable = false)
	private DeliveryStatus status;
	
	@Column(nullable = false)
	private DeliveryType type;
	
	private String receiver;
	
	@Column(nullable = false)
	private double tax;
}
