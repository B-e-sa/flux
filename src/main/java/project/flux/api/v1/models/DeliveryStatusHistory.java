package project.flux.api.v1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import project.flux.api.v1.models.common.DatabaseEntity;
import project.flux.api.v1.models.common.enums.DeliveryStatus;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class DeliveryStatusHistory extends DatabaseEntity {
	@ManyToOne
	@JoinColumn(name="delivery_id", nullable=false)
	private Delivery delivery;
	
	@Column(nullable = false)
	private DeliveryStatus status;
}
