package com.davidgjm.cloud.lbs.amap.webservice.services;

import com.davidgjm.cloud.lbs.amap.config.AmapRestUrls;
import com.davidgjm.cloud.lbs.amap.config.AmapSettings;
import com.davidgjm.cloud.lbs.amap.webservice.GeoRequest;
import com.davidgjm.cloud.lbs.amap.webservice.GeoResponse;
import com.davidgjm.cloud.lbs.amap.webservice.WSRequest;
import com.davidgjm.cloud.lbs.amap.webservice.WSResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Service
public class AmapGeoCodeServiceImpl implements AmapGeoCodeService {
    private final AmapSettings amapSettings;
    private final AmapRestUrls restUrls;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public AmapGeoCodeServiceImpl(AmapSettings amapSettings, AmapRestUrls restUrls, RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.amapSettings = amapSettings;
        this.restUrls = restUrls;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    private <Q extends WSRequest> UriComponentsBuilder buildGetBuilder(String url, Q request) {
        Map<String, Object> params = objectMapper.convertValue(request, Map.class);


        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(url)
                .queryParam("key", amapSettings.getApikey());
        params.forEach(uriComponentsBuilder::queryParam);

        return uriComponentsBuilder;
    }

    private <Q extends WSRequest, R extends WSResponse> R submitGetRequest(String url, Q request, Class<R> responseType) {
        UriComponentsBuilder uriComponentsBuilder = buildGetBuilder(url, request);
        ResponseEntity<String> responseEntity=restTemplate.getForEntity(uriComponentsBuilder.build().encode().toUri(), String.class );

        HttpStatus status = responseEntity.getStatusCode();
        String responseBody = responseEntity.getBody();
        log.debug("response status: {}", status);
        log.debug("response details: {}", responseBody);
        R response = null;
        try {
            response = objectMapper.readValue(responseBody, responseType);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
        log.info("Response info code: {}", response.getInfocode());
        return response;
    }

    @Override
    public GeoResponse getGeoCodeByAddress(GeoRequest request) {
        return submitGetRequest(restUrls.getGeocodeGeo(), request, GeoResponse.class);
    }
}
