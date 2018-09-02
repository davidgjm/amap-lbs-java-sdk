package com.davidgjm.cloud.lbs.amap.controllers;

import com.davidgjm.cloud.lbs.amap.domain.Poi;
import com.davidgjm.cloud.lbs.amap.webservice.GeoRequest;
import com.davidgjm.cloud.lbs.amap.webservice.GeoResponse;
import com.davidgjm.cloud.lbs.amap.webservice.KeywordSearchRequest;
import com.davidgjm.cloud.lbs.amap.webservice.KeywordSearchResponse;
import com.davidgjm.cloud.lbs.amap.webservice.services.AmapGeoCodeService;
import com.davidgjm.cloud.lbs.amap.webservice.services.AmapPoiSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@RequestMapping("/test/ws")
@RestController
public class AmapApiValidationController {
    private final AmapGeoCodeService geoCodeService;
    private final AmapPoiSearchService poiSearchService;

    public AmapApiValidationController(AmapGeoCodeService geoCodeService, AmapPoiSearchService poiSearchService) {
        this.geoCodeService = geoCodeService;
        this.poiSearchService = poiSearchService;
    }

    @GetMapping("/geocode")
    @ResponseStatus(HttpStatus.OK)
    public GeoResponse getLocation(@RequestParam @NotNull @NotBlank String address, @RequestParam @NotBlank String city) {
        log.info("Getting location for {}", address);
        GeoRequest request = new GeoRequest();
        request.setAddress(address);
        request.setCity(city);
        GeoResponse response = geoCodeService.getGeoCodeByAddress(request);
        log.info("Geo response details: {}", response);
        return response;
    }


    @PostMapping("/search/keyword")
    @ResponseStatus(HttpStatus.OK)
    public List<Poi> poiSearchByKeyword(@RequestBody @NotNull KeywordSearchRequest request) {
        log.info("POI search by keyword {}", request);
        KeywordSearchResponse response = poiSearchService.keywordSearch(request);
        log.info("Geo response details: {}", response);
        return response.getPois();
    }


}
