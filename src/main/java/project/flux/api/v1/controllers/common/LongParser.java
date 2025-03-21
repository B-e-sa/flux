package project.flux.api.v1.controllers.common;

public class LongParser {
	public static long fromString(String string) {
		try {
			return Long.parseLong(string);
		} catch (Exception e) {
			return -1;
		}
	}
}
