package com.exampleGraphql.exampleGraphql.controller;

import com.exampleGraphql.exampleGraphql.GraphQLProvider;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/graphql/controllerP")
@RestController
public class GraphQLControllerServer {

    @Autowired
    GraphQLProvider provider;

    @PostMapping("/initializer")
    public ResponseEntity<Object> initializer(@RequestBody String query){
        ExecutionResult exc = provider.graphQL().execute(query);
        return ResponseEntity.ok(exc);
    }
}
