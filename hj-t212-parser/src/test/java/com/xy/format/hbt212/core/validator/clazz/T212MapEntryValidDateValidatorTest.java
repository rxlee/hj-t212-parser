package com.xy.format.hbt212.core.validator.clazz;

import com.xy.format.hbt212.model.verify.groups.GroupCommon;
import com.xy.format.hbt212.model.element.DataElement;
import com.xy.format.hbt212.model.expand.T212MapEntry;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.Assert.*;

public class T212MapEntryValidDateValidatorTest {

    @Test
    public void test(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<T212MapEntry>> e1 = validator.validate(T212MapEntry.of("yyyyMMddHHmmss","20180101123010"), GroupCommon.YYYYMMDDhhmmss.class);
        assertTrue(e1.isEmpty());
        Set<ConstraintViolation<T212MapEntry>> e2 = validator.validate(T212MapEntry.of("yyyyMMddHHmmsszzz","20180101123010123"),DataElement.Group.QN.class);
        assertTrue(e2.isEmpty());
    }
}