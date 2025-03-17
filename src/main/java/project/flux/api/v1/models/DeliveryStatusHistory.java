package project.flux.api.v1.models;

import jakarta.persistence.OneToOne;
import lombok.Getter;
import project.flux.api.v1.models.common.DatabaseEntity;
import project.flux.api.v1.models.enums.DeliveryStatus;

@Getter
public class DeliveryStatusHistory extends DatabaseEntity {
	@OneToOne
	private Delivery delivery;
	private DeliveryStatus status;
}
