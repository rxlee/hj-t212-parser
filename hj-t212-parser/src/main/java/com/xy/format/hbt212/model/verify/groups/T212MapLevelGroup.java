package com.xy.format.hbt212.model.verify.groups;

import com.xy.format.hbt212.model.standard.DataFlag;

/**
 * T212Map级别 验证组
 * @see DataFlag#V0
 */
@Deprecated
public interface T212MapLevelGroup {

    /**
     * 数据段级别
     */
    interface DataLevel{}

    /**
     * 数据区级别
     */
    interface CpDataLevel{}
}
