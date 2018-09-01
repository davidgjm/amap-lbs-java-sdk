package com.davidgjm.cloud.lbs.amap.webservice;

import com.davidgjm.cloud.lbs.amap.AbstractJacksonBackedTest;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class GeoResponseTest extends AbstractJacksonBackedTest {
    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testDeserialization() throws IOException {
        String text = "{\"status\":\"1\",\"info\":\"OK\",\"infocode\":\"10000\",\"count\":\"1\",\"geocodes\":[{\"formatted_address\":\"上海市黄浦区西藏中路/人民大道\",\"province\":\"上海市\",\"citycode\":\"021\",\"city\":\"上海市\",\"district\":\"黄浦区\",\"township\":[],\"neighborhood\":{\"name\":[],\"type\":[]},\"building\":{\"name\":[],\"type\":[]},\"adcode\":\"310101\",\"street\":[],\"number\":[],\"location\":\"121.476521,31.231312\",\"level\":\"道路交叉路口\"}]}";

        GeoResponse response = objectMapper.readValue(text, GeoResponse.class);
        assertNotNull(response);
        System.out.println(response);
    }
}