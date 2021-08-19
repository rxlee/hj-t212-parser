package com.xy.format.hbt212.core.validator.clazz;

import com.xy.format.hbt212.core.validator.field.ValidDate;
import com.xy.format.hbt212.core.validator.field.ValidDateValidator;
import com.xy.format.hbt212.model.expand.T212Map;

import javax.validation.ConstraintValidator;

/**
 */
public class FieldValidDateValidator
        extends FieldRegexSupportedValidator<FieldValidDate,ValidDate>
        implements ConstraintValidator<FieldValidDate,T212Map<String,?>> {

    public FieldValidDateValidator() {
        super(new ValidDateValidator());
    }

    @Override
    public String getField(FieldValidDate field) {
        return field.field();
    }

    @Override
    public ValidDate getAnnotation(FieldValidDate field) {
        return field.value();
    }

    @Override
    public boolean isFieldRegex(FieldValidDate field) {
        return field.regex();
    }

    @Override
    public String getFieldMessage(ValidDate value) {
        return value.message();
    }
}
