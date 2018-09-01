package com.davidgjm.cloud.lbs.amap.controllers;

import com.davidgjm.cloud.lbs.amap.webservice.GeoRequest;
import com.davidgjm.cloud.lbs.amap.webservice.GeoResponse;
import com.davidgjm.cloud.lbs.amap.webservice.services.AmapGeoCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Slf4j
@RequestMapping("/test/ws")
@RestController
public class AmapApiValidationController {
    private final AmapGeoCodeService geoCodeService;

    public AmapApiValidationController(AmapGeoCodeService geoCodeService) {
        this.geoCodeService = geoCodeService;
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
}
