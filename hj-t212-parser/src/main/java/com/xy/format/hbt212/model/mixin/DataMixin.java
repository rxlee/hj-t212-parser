package com.xy.format.hbt212.model.mixin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xy.format.hbt212.model.standard.DataFlag;
import com.xy.format.hbt212.model.standard.Data;

import java.util.List;

/**
 * 混合
 * 解决Map转为
 * @see Data 时剔除的字段
 */
@Deprecated
public abstract class DataMixin {

    @JsonIgnore
    abstract String getDataFlag();

    @JsonIgnore
    abstract void setDataFlag(List<DataFlag> dataFlag);

    @JsonIgnore
    abstract String getCp();

    @JsonIgnore
    abstract void setCp(String cp);
}
