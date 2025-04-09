package project.flux.api.v1.controllers.common;

import project.flux.api.v1.controllers.common.exceptions.BadRequestException;

public class Validator {
	public static long id(String string) {
		try {
			return Long.parseLong(string);
		} catch (Exception e) {
			throw new BadRequestException("Invalid id format");
		}
	}
}
