package com.davidgjm.cloud.lbs.amap.webservice.services;

import com.davidgjm.cloud.lbs.amap.config.AmapRestUrls;
import com.davidgjm.cloud.lbs.amap.config.AmapSettings;
import com.davidgjm.cloud.lbs.amap.filters.AmapOutputJsonFilter;
import com.davidgjm.cloud.lbs.amap.webservice.KeywordSearchRequest;
import com.davidgjm.cloud.lbs.amap.webservice.KeywordSearchResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AmapPoiSearchServiceImpl implements AmapPoiSearchService {

    private final AmapRestUrls restUrls;
    private final AmapWSApiService wsApiService;

    public AmapPoiSearchServiceImpl(AmapRestUrls restUrls, AmapWSApiService wsApiService) {
        this.restUrls = restUrls;
        this.wsApiService = wsApiService;
    }

    @Override
    public KeywordSearchResponse keywordSearch(KeywordSearchRequest searchRequest) {
        return wsApiService.doGet(restUrls.getSearchKeyword(), searchRequest, KeywordSearchResponse.class,
                () -> Stream.of(whitelist_keyword).collect(Collectors.toSet()));
    }

    private static String[] whitelist_keyword = {
            "cities",
            "pois",
            "photos"
    };
}
