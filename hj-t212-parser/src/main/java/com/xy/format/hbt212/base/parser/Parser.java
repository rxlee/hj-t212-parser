package com.xy.format.hbt212.base.parser;

import com.xy.format.hbt212.exception.T212FormatException;

import java.io.Closeable;
import java.io.IOException;

/**
 * T212解析器
 */
public interface Parser<Target>
        extends Closeable {

    Target parse() throws T212FormatException, IOException;
}
