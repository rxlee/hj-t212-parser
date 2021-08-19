package com.xy.format.segment.base.cfger;

public interface Configured<Target> {

    /**
     * 被配置
     * @param by 目标配置器
     */
    void configured(Configurator<Target> by);
}
