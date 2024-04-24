package com.interbank.apirest.feign.client;


import com.interbank.apirest.dto.FeignDTO;
import com.interbank.apirest.feign.configuration.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "API", url = "${external.api.base-url}", configuration = FeignClientConfig.class)
public interface FeignClientApp {

    @GetMapping(value = "{monedaOrigen}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    FeignDTO getUsdRate(@PathVariable(value = "monedaOrigen") String monedaOrigen);

}