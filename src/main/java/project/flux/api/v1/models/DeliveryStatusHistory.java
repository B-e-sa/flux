package project.flux.api.v1.models;

import jakarta.persistence.Entity;
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
	@OneToOne
	private Delivery delivery;
	private DeliveryStatus status;
}
