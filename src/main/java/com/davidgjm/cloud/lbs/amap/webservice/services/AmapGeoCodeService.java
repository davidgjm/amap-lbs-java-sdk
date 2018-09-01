package com.davidgjm.cloud.lbs.amap.webservice.services;

import com.davidgjm.cloud.lbs.amap.webservice.GeoRequest;
import com.davidgjm.cloud.lbs.amap.webservice.GeoResponse;

public interface AmapGeoCodeService {

    GeoResponse getGeoCodeByAddress(GeoRequest request);
}
