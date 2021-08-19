package com.xy.format.hbt212.model.verify.groups;

import com.xy.format.hbt212.model.standard.DataFlag;

/**
 * 验证组
 */
public interface Group {

    /**
     * 分包模式
     */
    interface SubPack {}

    /**
     * 版本 验证组
     * @see DataFlag#V0
     */
    interface Version {

        /**
         * 2005版
         */
        interface V2005 {}

        /**
         * 2017版
         */
        interface V2017 {}
    }

}
