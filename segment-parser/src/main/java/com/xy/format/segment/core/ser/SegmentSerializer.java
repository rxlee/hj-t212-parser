package com.xy.format.segment.core.ser;

import com.xy.format.segment.core.SegmentGenerator;
import com.xy.format.segment.exception.SegmentFormatException;

import java.io.IOException;

/**
 *
 */
public interface SegmentSerializer<Target> {

    void serialize(SegmentGenerator generator, Target target) throws IOException, SegmentFormatException;
}
