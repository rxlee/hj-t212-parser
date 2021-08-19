package com.xy.format.segment.base.cfger;

public interface Configurator<Target> {

    /**
     * 配置
     * @param target 配置目标
     */
    void config(Target target);
}
