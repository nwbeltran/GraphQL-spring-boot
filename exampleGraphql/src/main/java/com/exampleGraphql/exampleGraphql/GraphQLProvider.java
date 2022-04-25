package com.exampleGraphql.exampleGraphql;

import com.exampleGraphql.exampleGraphql.DataFetchers.DeliveryResolver;
import com.exampleGraphql.exampleGraphql.DataFetchers.GraphQLDataFetchers;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.TypeResolver;
import graphql.schema.idl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

@Service
public class GraphQLProvider {

    private GraphQL graphQL;

    @Autowired
    GraphQLDataFetchers graphQLDataFetchers;

    @Autowired
    DeliveryResolver deliveryResolver;

    @Bean
    public GraphQL graphQL(){
        return this.graphQL;
    }

    @PostConstruct
    public void init()throws IOException{
        URL url = Resources.getResource("schema.graphqls");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }


    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(TypeRuntimeWiring.newTypeWiring("Query")
                        .dataFetcher("init", graphQLDataFetchers.getDataFetcher()))
                //.type(TypeRuntimeWiring.newTypeWiring("Mutation").typeResolver("delivery",
                  //      deliveryResolver.delivery()
                //))
                .build();
    }
}
