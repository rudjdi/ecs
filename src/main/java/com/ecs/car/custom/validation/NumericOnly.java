package com.ecs.car.custom.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NumericOnlyValidationImpl.class)
public @interface NumericOnly {
    String message() default "must be a numeric value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
