package com.xy.format.segment.core.deser;

import com.xy.format.segment.core.SegmentParser;
import com.xy.format.segment.exception.SegmentFormatException;

import java.io.IOException;

public interface SegmentDeserializer<Target> {

    Target deserialize(SegmentParser parser) throws IOException, SegmentFormatException;
}
