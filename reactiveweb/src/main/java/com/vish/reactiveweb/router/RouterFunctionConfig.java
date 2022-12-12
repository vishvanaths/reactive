package com.vish.reactiveweb.router;


import com.vish.reactiveweb.handler.FluxHandlerFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class RouterFunctionConfig {

    @Bean
    public RouterFunction<ServerResponse> route(FluxHandlerFunction handlerFunction){
        return RouterFunctions
                .route(GET("/functional/mono").and(accept(MediaType.APPLICATION_JSON)),handlerFunction::getMono);
    }
}
