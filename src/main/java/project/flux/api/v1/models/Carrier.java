package project.flux.api.v1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.flux.api.v1.models.common.DatabaseEntity;
import project.flux.api.v1.models.common.enums.DeliveryType;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Carrier extends DatabaseEntity {
	@Column(nullable = false, unique = true)
	private String name;
	
	@Column(name = "delivery_type", nullable = false)
	private DeliveryType deliveryType;
	
	@Column(name = "base_tax", nullable = false)
	private double baseTax;
	
	public Carrier(String name, DeliveryType deliveryType, double baseTax) {
		this.name = name;
		this.deliveryType = deliveryType;
		this.baseTax = baseTax != 0 
				? baseTax 
				: 20 * Math.random() * this.deliveryType.getPrice();
	}
}
