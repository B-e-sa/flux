package project.flux.api.v1.models.common.decorators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = EnumValidatorConstraint.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EnumValidator {
	Class<? extends Enum<?>> enumClass();
	String message() default "Invalid value, consult the API documentation for the available values";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}