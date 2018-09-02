package com.davidgjm.cloud.lbs.amap.webservice.services;

import com.davidgjm.cloud.lbs.amap.webservice.KeywordSearchRequest;
import com.davidgjm.cloud.lbs.amap.webservice.KeywordSearchResponse;

public interface AmapPoiSearchService {

    KeywordSearchResponse keywordSearch(KeywordSearchRequest searchRequest);
}
