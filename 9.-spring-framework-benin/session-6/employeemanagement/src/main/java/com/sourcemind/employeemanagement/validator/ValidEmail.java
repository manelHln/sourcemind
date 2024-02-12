package com.sourcemind.employeemanagement.validator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmail {
    String message() default "L'email est invalide";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}