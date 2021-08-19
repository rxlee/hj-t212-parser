package com.xy.format.hbt212.core.validator.clazz;

import com.xy.format.hbt212.model.expand.T212Map;
import com.xy.format.hbt212.model.verify.groups.Group;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class FieldCValidatorTest {

    public Map<String,String> map;

    @Before
    public void init(){
        map = new HashMap<>();
        map.put("ST","12");
        map.put("CN","1234567-");
    }

    @SuppressWarnings("Duplicates")
    @Test
    public void test(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        T212Map t212Map = T212Map.createDataLevel(map);

        Set<ConstraintViolation<T212Map>> e1 = validator.validate(t212Map,
                Default.class, Group.Version.V2005.class);
        assertEquals(e1.size(),1);
    }
}