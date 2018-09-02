package com.davidgjm.cloud.lbs.amap.webservice.services;

import com.davidgjm.cloud.lbs.amap.webservice.WSRequest;
import com.davidgjm.cloud.lbs.amap.webservice.WSResponse;

import java.util.Set;
import java.util.function.Supplier;

public interface AmapWSApiService {

    <Q extends WSRequest, R extends WSResponse> R doGet(String url, Q request, Class<R> responseType, Supplier<Set<String>> whitelistProvider);
}
