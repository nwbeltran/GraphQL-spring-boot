package com.exampleGraphql.exampleGraphql.DataFetchers;

import com.exampleGraphql.exampleGraphql.model.ResponseOrquestation;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
@AllArgsConstructor
public class DeliveryResolver implements GraphQLMutationResolver {

    public ResponseOrquestation delivery(String state, String requestID){
        return ResponseOrquestation.builder()
                .requestID(UUID.randomUUID().toString())
                .urlState("OTP_VALIDATED")
                .build();
    }
}
