package com.xy.format.hbt212.core.validator.clazz;

import com.xy.format.hbt212.model.expand.T212Map;

import javax.validation.ConstraintValidator;
import java.lang.annotation.Annotation;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 */
public abstract class FieldRegexSupportedValidator<A extends Annotation,AF extends Annotation>
        extends FieldValidator<A,T212Map<String,?>,AF,String> {

    private Predicate<String> predicate;

    public FieldRegexSupportedValidator(ConstraintValidator<AF, String> constraintValidator) {
        super(constraintValidator);
    }

    @Override
    public void initialize(A a) {
        super.initialize(a);
        if(isFieldRegex(a)){
            predicate = Pattern.compile(field).asPredicate();
        }
    }

    public abstract boolean isFieldRegex(A a);

    @Override
    public String getFieldValue(T212Map<String,?> value, String field) {
        if(predicate != null){
            Optional<String> optional = value.keySet()
                    .stream()
                    .filter(key -> predicate.test(key))
                    .findFirst();
            if(optional.isPresent()){
                return (String) value.get(optional.get());
            }
        }
        if(!value.containsKey(field)){
            return null;
        }
        return (String) value.get(field);
    }

}
