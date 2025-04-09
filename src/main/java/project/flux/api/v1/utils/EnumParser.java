package project.flux.api.v1.utils;

public class EnumParser {
	 public static <T extends Enum<T>> T fromString(String string, Class<T> enumClass) {
        T[] values = enumClass.getEnumConstants();
        
        for (T value : values)
        	if (value.toString().equals(string))
        		return value;
        
		return null;
    }
}
