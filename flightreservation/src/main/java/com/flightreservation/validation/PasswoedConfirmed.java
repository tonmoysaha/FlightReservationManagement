package com.flightreservation.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserNameUniqueValidator.class)
public @interface PasswoedConfirmed {

	String message() default "Password Do not match";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
