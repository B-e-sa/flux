package project.flux.api.v1.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import project.flux.api.v1.models.common.DatabaseEntity;
import project.flux.api.v1.models.enums.DeliveryStatus;
import project.flux.api.v1.models.enums.DeliveryType;

@Getter
public class Delivery extends DatabaseEntity {	
	@OneToOne
	@Column(nullable = false)
	private Carrier carrier;
	
	@OneToMany
	@Column(nullable = false)
	private Recipient recipient;

	@OneToOne
	@Column(nullable = false)
	private Address startAddress;
	
	@OneToOne
	@Column(nullable = false)
	private Address finalAddress;
	
	// @OneToOne
	// private long admin;
	
	@Column(nullable = false, unique = true)
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
	
	private Date updatedAt;
}
