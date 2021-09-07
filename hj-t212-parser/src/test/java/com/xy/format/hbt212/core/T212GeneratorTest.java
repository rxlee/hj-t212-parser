package com.xy.format.hbt212.core;

import com.xy.format.hbt212.core.feature.GeneratorFeature;
import com.xy.format.hbt212.exception.T212FormatException;
import com.xy.format.hbt212.model.standard.CpData;
import com.xy.format.hbt212.model.standard.Data;
import com.xy.format.hbt212.model.standard.DataFlag;
import com.xy.format.segment.base.cfger.Feature;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class T212GeneratorTest {

    @Test
    public void flag(){
        Data resp = new Data();
        List<DataFlag> FLAG_NOT_WAIT_RESPONSE=new ArrayList<>();
        FLAG_NOT_WAIT_RESPONSE.add(DataFlag.V0);
        resp.setDataFlag(FLAG_NOT_WAIT_RESPONSE);
        resp.setQn("20210907145012163");
        resp.setSt("91");
        resp.setCn("9014");
        resp.setPw("123456");
        resp.setMn("ZG130127201709");
        resp.setCp(new CpData());

        T212Mapper mapper = new T212Mapper()
                .enableDefaultVerifyFeatures()
                .enableDefaultParserFeatures();
        try {
            String s = mapper.writeDataAsString(resp);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (T212FormatException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void generate() {
        String data = "ST=32;CN=2011;PW=123456;MN=LD130133000015;CP=&&DataTime=20160824003817000;B01-Rtd=36.91;011-Rtd=231.0,011-Flag=N;060-Rtd=1.803,060-Flag=N&&";
        StringWriter writer = new StringWriter();
        T212Generator generator = new T212Generator(writer);
        generator.setGeneratorFeature(Feature.collectFeatureDefaults(GeneratorFeature.class));
        try {
            assertEquals(generator.writeHeader(),2);
            assertEquals(generator.writeDataLen(new char[]{'0','1','3','9'}),4);
            assertEquals(generator.writeData(data.toCharArray()),139);
            assertEquals(generator.writeCrc(new char[]{'4','9','8','0'}),4);
            assertEquals(generator.writeFooter(),2);

            assertEquals(writer.toString(),"##0139" + data + "4980\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            generator.close();
        }
    }

    @Test
    public void crc() {
        String data = "ST=32;CN=2011;PW=123456;MN=LD130133000015;CP=&&DataTime=20160824003817000;B01-Rtd=36.91;011-Rtd=231.0,011-Flag=N;060-Rtd=1.803,060-Flag=N&&";
        StringWriter writer = new StringWriter();
        T212Generator generator = new T212Generator(writer);
        generator.setGeneratorFeature(Feature.collectFeatureDefaults(GeneratorFeature.class));
        try {
            assertEquals(generator.writeHeader(),2);
            assertEquals(generator.writeDataAndLenAndCrc(data.toCharArray()),139 + 4+ 4);
            assertEquals(generator.writeFooter(),2);

            assertEquals(writer.toString(),"##0139" + data + "4980\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            generator.close();
        }
    }

    @Test
    public void testWriteHexInt32() {
        StringWriter writer = new StringWriter();
        T212Generator generator = new T212Generator(writer);
        generator.setGeneratorFeature(Feature.collectFeatureDefaults(GeneratorFeature.class));
        try {
            assertEquals(generator.writeHexInt32(12),4);
            assertEquals(generator.writeHexInt32(123),4);
            assertEquals(generator.writeHexInt32(1234),4);

            assertEquals(writer.toString(),"000c007b04d2");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            generator.close();
        }
    }

}