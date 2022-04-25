package com.example.bff.demo.controller;

import com.example.bff.demo.service.RemoteFeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    RemoteFeignClient client;

    @PostMapping("initializerData")
    public ResponseEntity initializer(@RequestBody String query){
        return client.initializer(query);
    }

    @PostMapping
    public ResponseEntity finalData(){
        return ResponseEntity.ok().build();
    }
}
