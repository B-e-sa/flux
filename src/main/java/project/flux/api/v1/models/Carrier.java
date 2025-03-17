package project.flux.api.v1.models;

import lombok.Getter;
import project.flux.api.v1.models.common.DatabaseEntity;

@Getter
public class Carrier extends DatabaseEntity {
	private String name;
}
