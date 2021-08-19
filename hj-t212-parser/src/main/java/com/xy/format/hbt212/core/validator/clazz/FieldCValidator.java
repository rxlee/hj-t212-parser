package com.xy.format.hbt212.core.validator.clazz;

import com.xy.format.hbt212.core.validator.field.C;
import com.xy.format.hbt212.core.validator.field.CValidator;
import com.xy.format.hbt212.model.expand.T212Map;

import javax.validation.ConstraintValidator;

/**
 */
public class FieldCValidator
        extends FieldRegexSupportedValidator<FieldC,C>
        implements ConstraintValidator<FieldC,T212Map<String,?>> {

    public FieldCValidator() {
        super(new CValidator());
    }

    @Override
    public String getField(FieldC fieldC) {
        return fieldC.field();
    }

    @Override
    public C getAnnotation(FieldC fieldC) {
        return fieldC.value();
    }

    @Override
    public boolean isFieldRegex(FieldC fieldC) {
        return fieldC.regex();
    }

    @Override
    public String getFieldMessage(C value) {
        return value.message();
    }

}
