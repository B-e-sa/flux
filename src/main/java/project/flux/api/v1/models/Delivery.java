package project.flux.api.v1.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import project.flux.api.v1.models.common.DatabaseEntity;
import project.flux.api.v1.models.common.enums.DeliveryStatus;
import project.flux.api.v1.models.common.enums.DeliveryType;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Delivery extends DatabaseEntity {	
	@OneToOne
	@JoinColumn(name = "carrier_id", referencedColumnName = "id")
	private Carrier carrier;

	@OneToOne
	@JoinColumn(name = "start_address_id", 
				referencedColumnName = "id", 
				nullable = false)
	private Address startAddress;
	
	@OneToOne
	@JoinColumn(name = "final_address_id", 
				referencedColumnName = "id", 
				nullable = false)
	private Address finalAddress;
	
	@ManyToOne
	@JoinColumn(name="recipient_id", nullable=false)
	private Recipient recipient;
	
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
