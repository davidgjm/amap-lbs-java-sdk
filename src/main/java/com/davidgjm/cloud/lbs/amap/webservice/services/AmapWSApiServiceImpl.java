package com.davidgjm.cloud.lbs.amap.webservice.services;

import com.davidgjm.cloud.lbs.amap.config.AmapSettings;
import com.davidgjm.cloud.lbs.amap.filters.AmapOutputJsonFilter;
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
import java.util.Set;
import java.util.function.Supplier;

@Slf4j
@Service
public class AmapWSApiServiceImpl implements AmapWSApiService {
    private final AmapSettings amapSettings;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final AmapOutputJsonFilter jsonFilter;

    public AmapWSApiServiceImpl(AmapSettings amapSettings, RestTemplate restTemplate, ObjectMapper objectMapper, AmapOutputJsonFilter jsonFilter) {
        this.amapSettings = amapSettings;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.jsonFilter = jsonFilter;
    }


    private <Q extends WSRequest> UriComponentsBuilder buildGetBuilder(String url, Q request) {
        Map<String, Object> params = objectMapper.convertValue(request, Map.class);


        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(url)
                .queryParam("key", amapSettings.getApikey());
        params.forEach(uriComponentsBuilder::queryParam);

        return uriComponentsBuilder;
    }

    private String filterResponseBody(String responseBody, Supplier<Set<String>> whitelistProvider) {
        if (whitelistProvider == null) {
            return responseBody;
        } else {
            return jsonFilter.filter(responseBody, whitelistProvider);
        }
    }

    private <R extends WSResponse> R produceResponseObject(String responseBody, Class<R> responseType,Supplier<Set<String>> whitelistProvider) {
        log.debug("response details: {}", responseBody);

        log.info("Pre-processing response body for deserialization");
        String filterResponseBody = filterResponseBody(responseBody, whitelistProvider);
        R response = null;
        try {
            response = objectMapper.readValue(filterResponseBody, responseType);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
        log.info("Response info code: {}", response.getInfocode());
        return response;
    }


    @Override
    public <Q extends WSRequest, R extends WSResponse> R doGet(String url, Q request, Class<R> responseType, Supplier<Set<String>> whitelistProvider) {

        UriComponentsBuilder uriComponentsBuilder = buildGetBuilder(url, request);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uriComponentsBuilder.build().encode().toUri(), String.class);

        HttpStatus status = responseEntity.getStatusCode();
        String responseBody = responseEntity.getBody();
        log.debug("response status: {}", status);
        return produceResponseObject(responseBody, responseType, whitelistProvider);
    }
}
