package com.xy.format.hbt212.base.parser;

import java.io.IOException;
import java.io.PushbackReader;

/**
 * 字符流解析器
 */
public abstract class PushBackReaderParser<Target>
        implements Parser<Target> {

    protected PushbackReader reader;

    public PushBackReaderParser(PushbackReader reader){
        this.reader = reader;
    }


    @Override
    public void close(){
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
