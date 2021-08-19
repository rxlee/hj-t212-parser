package com.xy.format.hbt212.base;

/**
 */
public interface Converter<SRC,TAR> {

    TAR convert(SRC src) throws Exception;
}
