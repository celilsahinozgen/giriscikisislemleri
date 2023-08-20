package com.Resopsion.giriscikisislemleri.valid;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {TCKNValidator.class})
@Target( { METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface TCKNConstraint {


    String message() default "türkiye kimlik numarası hatalıdır!!!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
