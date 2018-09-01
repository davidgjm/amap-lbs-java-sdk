package com.davidgjm.cloud.lbs.amap.webservice;

import com.davidgjm.cloud.lbs.amap.AbstractJacksonBackedTest;
import com.oracle.tools.packager.mac.MacAppBundler;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class GeoRequestTest extends AbstractJacksonBackedTest {


    @Test
    public void testObject2Map() {
        GeoRequest request = new GeoRequest();
        request.setAddress("西藏中路人民大道");
        request.setCity("021");

        @SuppressWarnings("unchecked")
        Map<String, Object> convertedMap = objectMapper.convertValue(request, Map.class);
        assertTrue(convertedMap!=null && !convertedMap.isEmpty());
        System.out.println(convertedMap);
    }
}