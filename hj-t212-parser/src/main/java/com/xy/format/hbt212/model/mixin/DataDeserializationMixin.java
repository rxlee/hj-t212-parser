package com.xy.format.hbt212.model.mixin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xy.format.hbt212.model.standard.Data;

/**
 * 混合
 * 反序列化
 * 解决Map转为
 * @see Data 时剔除的字段
 */
@JsonIgnoreProperties(value={ "Flag","CP" }, allowGetters=true)
public abstract class DataDeserializationMixin {

    @JsonProperty("QN")
    abstract void setQn(String qn);

    @JsonProperty("PNUM")
    abstract void setpNum(int pNum);

    @JsonProperty("PNO")
    abstract void setpNo(int pNo);

    @JsonProperty("ST")
    abstract void setSt(String st);

    @JsonProperty("CN")
    abstract void setCn(String cn);

    @JsonProperty("PW")
    abstract void setPw(String pw);

    @JsonProperty("MN")
    abstract void setMn(String mn);

    @JsonIgnore
    abstract String getDataFlag();

    @JsonIgnore
    abstract void setCp(String cp);

}
