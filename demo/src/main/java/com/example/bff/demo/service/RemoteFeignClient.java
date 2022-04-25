package com.example.bff.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="initializer",url = "http://localhost:8080/graphql/controllerP")
public interface RemoteFeignClient {

    @PostMapping("/initializer")
    ResponseEntity initializer(@RequestBody String query);
}
