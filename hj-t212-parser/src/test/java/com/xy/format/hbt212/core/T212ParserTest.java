package com.xy.format.hbt212.core;

import com.xy.format.hbt212.core.feature.ParserFeature;
import com.xy.format.hbt212.exception.T212FormatException;
import com.xy.format.hbt212.model.standard.Data;
import com.xy.format.segment.base.cfger.Feature;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class T212ParserTest {

    @Test
    public void example() throws IOException, T212FormatException {
        String h212 = "##0144ST=31;CN=2021;PW=123456;MN=ZG130102201666;CP=&&DataTime=20180119131000;SB1-RS=0;SB2-RS=0;SB3-RS=0;SB4-RS=0;SB5-RS=0;SB6-RS=0;SB7-RS=0;SB8-RS=0&&CAC1\r\n";

        T212Mapper mapper = new T212Mapper()
                .enableDefaultVerifyFeatures()
                .enableDefaultParserFeatures();

        //从T212字符串中读取Data对象
        Data data = mapper.readData(h212);

        //.... use data

        //create data and set it
        data.setPw("000000");
        //将Data对象写入成T212字符串
        String result = mapper.writeDataAsString(data);

        System.out.println(result);
//        assertEquals(result,"##0136ST=32;CN=2011;PW=000000;MN=LD130133000015;CP=&&DataTime=20160824003817;011-Rtd=231.0,011-Flag=N;B01-Rtd=36.91;060-Rtd=1.803,060-Flag=N&&1dc0\r\n");
    }

    @Test
    public void parse() {
        String data = "##0139ST=32;CN=2011;PW=123456;MN=LD130133000015;CP=&&DataTime=20160824003817000;B01-Rtd=36.91;011-Rtd=231.0,011-Flag=N;060-Rtd=1.803,060-Flag=N&&4980\r\n";
        StringReader reader = new StringReader(data);
        T212Parser parser = new T212Parser(reader);
        parser.setParserFeature(Feature.collectFeatureDefaults(ParserFeature.class));
        try {
            assertArrayEquals(parser.readHeader(),new char[]{'#','#'});
            assertArrayEquals(parser.readDataLen(),new char[]{'0','1','3','9'});
            assertEquals(parser.readData(139).length,139);
            assertArrayEquals(parser.readCrc(),new char[]{'4','9','8','0'});
            assertArrayEquals(parser.readFooter(),new char[]{'\r','\n'});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            parser.close();
        }
    }

    @Test
    public void crc() {
        String data = "##0139ST=32;CN=2011;PW=123456;MN=LD130133000015;CP=&&DataTime=20160824003817000;B01-Rtd=36.91;011-Rtd=231.0,011-Flag=N;060-Rtd=1.803,060-Flag=N&&4980\r\n";
        StringReader reader = new StringReader(data);
        T212Parser parser = new T212Parser(reader);
        parser.setParserFeature(Feature.collectFeatureDefaults(ParserFeature.class));
        try {
            assertArrayEquals(parser.readHeader(),new char[]{'#','#'});
            assertArrayEquals(parser.readDataLen(),new char[]{'0','1','3','9'});
            assertEquals(parser.readDataAndCrc(139).length,139);
            assertArrayEquals(parser.readFooter(),new char[]{'\r','\n'});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            parser.close();
        }
    }

    @Test
    public void testFeature_HEADER_CONSTANT() {
        String data = "0#";
        StringReader reader = new StringReader(data);
        T212Parser parser = new T212Parser(reader);
        parser.setParserFeature(ParserFeature.HEADER_CONSTANT.getMask());
        try {
            parser.readHeader();
        } catch (IOException | T212FormatException e) {
            assertTrue(e.getMessage().contains("Static"));
        }

        reader = new StringReader(data);
        parser = new T212Parser(reader);
        try {
            char[] h = parser.readHeader();
            assertArrayEquals(h,new char[]{'0','#'});
        } catch (IOException | T212FormatException e) {
            assert false;
        }
    }

    @Test
    public void testFeature_FOOTER_CONSTANT() {
        String data = "\r\r";
        StringReader reader = new StringReader(data);
        T212Parser parser = new T212Parser(reader);
        parser.setParserFeature(ParserFeature.FOOTER_CONSTANT.getMask());
        try {
            parser.readFooter();
        } catch (IOException | T212FormatException e) {
            assertTrue(e.getMessage().contains("Static"));
        }

        reader = new StringReader(data);
        parser = new T212Parser(reader);
        try {
            char[] f = parser.readFooter();
            assertArrayEquals(f,new char[]{'\r','\r'});
        } catch (IOException | T212FormatException e) {
            assert false;
        }
    }

}