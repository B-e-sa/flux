package project.flux.api.v1.services.common;

import java.util.function.Consumer;

public class Mapper {
	public static <T> void updateIfChanged(Consumer<T> setter, T oldValue, T newValue) {
        if (newValue != null && !newValue.equals(oldValue))
            setter.accept(newValue);
    }
	
	public static <T> void updateIfNullableChanged(Consumer<T> setter, T oldValue, T newValue) {
        if (!newValue.equals(oldValue))
            setter.accept(newValue);
    }
}
