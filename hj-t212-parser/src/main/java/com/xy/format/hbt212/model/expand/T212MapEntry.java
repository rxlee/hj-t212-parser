package com.xy.format.hbt212.model.expand;

import com.xy.format.hbt212.core.validator.field.C;
import com.xy.format.hbt212.core.validator.field.N;
import com.xy.format.hbt212.core.validator.field.ValidDate;
import com.xy.format.hbt212.model.element.DataElement;
import com.xy.format.hbt212.model.verify.groups.GroupCommon;

import javax.validation.constraints.*;

/**
 * T212 Map
 * 解决无法对MAP进行验证定义问题
 */
public class T212MapEntry {

    private String key;

    @NotNull(groups = {
            DataElement.Group.QN.class,
            DataElement.Group.PNUM.class,
            DataElement.Group.PNO.class,
            DataElement.Group.ST.class,
            DataElement.Group.CN.class,
            DataElement.Group.PW.class,
            DataElement.Group.MN.class,
            DataElement.Group.Flag.class
    })
    @ValidDate(format = "yyyyMMddHHmmssSSS", groups = DataElement.Group.QN.class)
    @Max(value = 4, groups = DataElement.Group.PNUM.class)
    @Max(value = 4, groups = DataElement.Group.PNO.class)
    @Max(value = 2, groups = DataElement.Group.ST.class)
    @Max(value = 4, groups = DataElement.Group.CN.class)
    @Max(value = 6, groups = DataElement.Group.PW.class)
    @Max(value = 14, groups = DataElement.Group.MN.class)
    @Max(value = 3, groups = DataElement.Group.Flag.class)
    @Min(value = 1, groups = DataElement.Group.Flag.class)
    @Max(value = 960, groups = DataElement.Group.CP.class)

    @ValidDate(format = "yyyyMMddHHmmss", groups = GroupCommon.YYYYMMDDhhmmss.class)
    @ValidDate(format = "HHmmss", groups = GroupCommon.hhmmss.class)
    @N(integer = 1, groups = GroupCommon.N1.class)
    @N(integer = 2, groups = GroupCommon.N2.class)
    @N(integer = 3, groups = GroupCommon.N3.class)
    @N(integer = 4, groups = GroupCommon.N4.class)
    @N(integer = 14, groups = GroupCommon.N14.class)
    @N(integer = 2, fraction = 2, groups = GroupCommon.N2_2.class)
    @N(integer = 3, fraction = 1, groups = GroupCommon.N3_1.class)
    @C(len = 1, groups = GroupCommon.C1.class)
    @C(len = 4, groups = GroupCommon.C4.class)
    @C(len = 6, groups = GroupCommon.C6.class)
    @C(len = 24, groups = GroupCommon.C24.class)

    private String value;

    public T212MapEntry(String key, String value){
        this.key = key;
        this.value = value;
    }



    public static T212MapEntry of(String key, String value){
        return new T212MapEntry(key,value);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
