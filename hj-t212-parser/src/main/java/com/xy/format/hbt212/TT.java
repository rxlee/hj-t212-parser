package com.xy.format.hbt212;

import com.xy.format.hbt212.core.T212Mapper;
import com.xy.format.hbt212.exception.T212FormatException;
import com.xy.format.hbt212.model.standard.Data;

import java.io.IOException;

public class TT {
    public static void main(String[] args) throws T212FormatException, IOException {
        String h212 = "##0139ST=32;CN=2011;PW=123456;MN=LD130133000015;CP=&&DataTime=20160824003817000;B01-Rtd=36.91;011-Rtd=231.0,011-Flag=N;060-Rtd=1.803,060-Flag=N&&4980\r\n";

        T212Mapper mapper = new T212Mapper()
                .enableDefaultVerifyFeatures()
                .enableDefaultParserFeatures();

        Data data = mapper.readData(h212);

        data.setPw("000000");
        String result = mapper.writeDataAsString( data);
        System.out.println(result);
    }
}
