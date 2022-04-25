package com.exampleGraphql.exampleGraphql.DataFetchers;

import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {

    private static List<Map<String,Object>> authentications = Arrays.asList(
            ImmutableMap.of(
                    "requestID", "132465789",
                    "appId", 249,
                    "templateNumberSms", 96,
                    "templateNumberEmail", 14,
                    "previouslyAuthenticated", Boolean.FALSE)
    );

    public DataFetcher getDataFetcher(){
        return dataFetchingEnvironment -> {
            String requesdId = dataFetchingEnvironment.getArgument("requestID");
            return authentications
                    .stream()
                    .filter(auth -> auth.get("requestID").equals(requesdId))
                    .findFirst()
                    .orElse(null);
        };
    }
}
