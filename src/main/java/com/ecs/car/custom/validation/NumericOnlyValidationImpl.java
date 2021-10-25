package com.ecs.car.custom.validation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

public class NumericOnlyValidationImpl implements ConstraintValidator<NumericOnly,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
    	return StringUtils.isNumeric(value);
    }
}