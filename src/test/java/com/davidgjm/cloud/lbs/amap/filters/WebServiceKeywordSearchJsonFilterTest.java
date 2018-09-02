package com.davidgjm.cloud.lbs.amap.filters;

import com.davidgjm.cloud.lbs.amap.AbstractJacksonBackedTest;
import com.davidgjm.cloud.lbs.amap.webservice.KeywordSearchResponse;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class WebServiceKeywordSearchJsonFilterTest extends AbstractJacksonBackedTest {
    AmapOutputJsonFilter jsonFilter;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        jsonFilter = new AmapOutputJsonFilterImpl();
    }

    @Test
    public void testJsonFilter() throws IOException {
        String filtered = jsonFilter.filter(rawText, () -> Stream.of(whitelistFields).collect(Collectors.toSet()));
        System.out.println(filtered);
        KeywordSearchResponse response =
                objectMapper.readValue(filtered, KeywordSearchResponse.class);
        System.out.println(response);
    }

    private static String rawText = "{\"status\":\"1\",\"count\":\"479\",\"info\":\"OK\",\"infocode\":\"10000\",\"suggestion\":{\"keywords\":[],\"cities\":[]},\"pois\":[{\"id\":\"B0FFIRVVO6\",\"name\":\"星星充电站(千禧海鸥大酒店)\",\"type\":\"汽车服务;充电站;充电站\",\"typecode\":\"011100\",\"biz_type\":[],\"address\":\"延安西路2588号\",\"location\":\"121.394563,31.197351\",\"tel\":\"4008280768\",\"distance\":[],\"biz_ext\":{\"rating\":[],\"cost\":[]},\"pname\":\"上海市\",\"cityname\":\"上海市\",\"adname\":\"长宁区\",\"importance\":[],\"shopid\":[],\"shopinfo\":\"0\",\"poiweight\":[],\"photos\":[]},{\"id\":\"B0FFGSJG0Q\",\"name\":\"星星充电站(浦江瑞和城壹街坊二期中1区)\",\"type\":\"汽车服务;充电站;充电站\",\"typecode\":\"011100\",\"biz_type\":[],\"address\":\"汇延路258弄9号楼前\",\"location\":\"121.518237,31.023952\",\"tel\":\"4008280768\",\"distance\":[],\"biz_ext\":{\"rating\":[],\"cost\":[]},\"pname\":\"上海市\",\"cityname\":\"上海市\",\"adname\":\"闵行区\",\"importance\":[],\"shopid\":[],\"shopinfo\":\"0\",\"poiweight\":[],\"photos\":[{\"url\":\"http://store.is.autonavi.com/showpic/e194ccfabe1260b1b2902e844be88113\",\"title\":[],\"provider\":[]},{\"url\":\"http://store.is.autonavi.com/showpic/b4816e7dc5656df39dd877c9fd57f871\",\"title\":[],\"provider\":[]},{\"url\":\"http://store.is.autonavi.com/showpic/4698f1c9c4c1daeb40976e74c2b67755\",\"title\":[],\"provider\":[]}]},{\"id\":\"B0FFI2OS4O\",\"name\":\"星星充电站(永康城佳兴苑)\",\"type\":\"汽车服务;充电站;充电站\",\"typecode\":\"011100\",\"biz_type\":[],\"address\":\"永跃路782弄南侧停车位57-63号车位\",\"location\":\"121.511142,31.034138\",\"tel\":[],\"distance\":[],\"biz_ext\":{\"rating\":[],\"cost\":[]},\"pname\":\"上海市\",\"cityname\":\"上海市\",\"adname\":\"闵行区\",\"importance\":[],\"shopid\":[],\"shopinfo\":\"0\",\"poiweight\":[],\"photos\":[]},{\"id\":\"B0FFI2ORZG\",\"name\":\"星星充电站(永康城丽华园)\",\"type\":\"汽车服务;充电站;充电站\",\"typecode\":\"011100\",\"biz_type\":[],\"address\":\"盐铁塘路272弄进门右转到底\",\"location\":\"121.509609,31.035808\",\"tel\":[],\"distance\":[],\"biz_ext\":{\"rating\":[],\"cost\":[]},\"pname\":\"上海市\",\"cityname\":\"上海市\",\"adname\":\"闵行区\",\"importance\":[],\"shopid\":[],\"shopinfo\":\"0\",\"poiweight\":[],\"photos\":[]},{\"id\":\"B0FFHIAA04\",\"name\":\"星星充电站(浦江维也纳酒店)\",\"type\":\"汽车服务;充电站;充电站\",\"typecode\":\"011100\",\"biz_type\":[],\"address\":\"浦江昌林路128号地下车库\",\"location\":\"121.523915,31.065429\",\"tel\":\"4008280768\",\"distance\":[],\"biz_ext\":{\"rating\":[],\"cost\":[]},\"pname\":\"上海市\",\"cityname\":\"上海市\",\"adname\":\"闵行区\",\"importance\":[],\"shopid\":[],\"shopinfo\":\"0\",\"poiweight\":[],\"photos\":[{\"url\":\"http://store.is.autonavi.com/showpic/ec4db3e620d8a74673258cf71409fe60\",\"title\":[],\"provider\":[]},{\"url\":\"http://store.is.autonavi.com/showpic/7e0ea0e6618082906d298d0ae8750135\",\"title\":[],\"provider\":[]},{\"url\":\"http://store.is.autonavi.com/showpic/92b05e31288ba9f79a7905bf3df5900a\",\"title\":[],\"provider\":[]}]}]}";

    private static String[] whitelistFields = {
            "cities",
            "pois",
            "photos"
    };
}