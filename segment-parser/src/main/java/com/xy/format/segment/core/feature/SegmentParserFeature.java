package com.xy.format.segment.core.feature;

import com.xy.format.segment.base.cfger.Feature;

public enum SegmentParserFeature implements Feature {

    /**
     * 忽略非法字符
     */
    IGNORE_INVAILD_SYMBOL(true),

    /**
     * 允许孤立的KEY出现
     */
    ALLOW_ISOLATED_KEY(true),

    /**
     * 允许NULL的KEY出现
     */
    @Deprecated
    ALLOW_NULL_KEY(false),

    /**
     * 允许KEY不闭合
     */
    ALLOW_KEY_NOT_CLOSED(true);


    private final boolean _defaultState;
    private final int _mask;

    SegmentParserFeature(boolean defaultState) {
        _defaultState = defaultState;
        _mask = (1 << ordinal());
    }

    @Override
    public boolean enabledByDefault() { return _defaultState; }

    @Override
    public int getMask() { return _mask; }

    @Override
    public boolean enabledIn(int flags) { return (flags & _mask) != 0; }

}
