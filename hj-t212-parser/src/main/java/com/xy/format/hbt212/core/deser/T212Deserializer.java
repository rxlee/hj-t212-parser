package com.xy.format.hbt212.core.deser;

import com.xy.format.hbt212.core.T212Parser;
import com.xy.format.hbt212.exception.T212FormatException;

import java.io.IOException;

/**
 * T212反序列化器
 */
public interface T212Deserializer<Target> {

    Target deserialize(T212Parser parser) throws IOException, T212FormatException;
}
