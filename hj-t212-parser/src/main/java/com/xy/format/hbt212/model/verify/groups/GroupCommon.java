package com.xy.format.hbt212.model.verify.groups;

/**
 * 常用类型 验证组
 */
public interface GroupCommon {
    interface N1{}
    interface N2{}
    interface N3{}
    interface N4{}
    interface N14{}
    interface N2_2{}
    interface N3_1{}
    interface C1{}
    interface C4{}
    interface C6{}
    interface C24{}

    /**
     * 对应JAVA的格式为
     * yyyyMMddHHmmssSSS
     */
    interface YYYYMMDDhhmmsszzz{}

    /**
     * 对应JAVA的格式为
     * yyyyMMddHHmmss
     */
    interface YYYYMMDDhhmmss{}

    /**
     * 对应JAVA的格式为
     * HHmmss
     */
    interface hhmmss{}
}
