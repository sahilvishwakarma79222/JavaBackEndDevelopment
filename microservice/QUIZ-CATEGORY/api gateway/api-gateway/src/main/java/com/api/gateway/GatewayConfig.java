package com.api.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {


    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){

//        .route("myQuizRoute",route-> route.path("/quiz/**")  // Route ID: कोई भी
//                .filters(f->f.rewritePath("/quiz/?(?<remaining>.*)","/${remaining}"))
//                .uri("lb://QUIZ-SERVICE")  //  Eureka registered name
//        )
//
//                .route("categoryApi",route-> route.path("/category/**")  // Route ID: कोई भी
//                        .filters(f->f.rewritePath("/category/?(?<remaining>.*)","/${remaining}"))
//                        .uri("lb://CATEGORY-SERVICE")  //  Eureka registered name
//                )
       return builder.routes()
               .route("category-service",route-> route.path("/category/**")
                       .filters(f->f.rewritePath("/category/?(?<remaining>.*)","/${remaining}"))
                       .uri("lb://CATEGORY-SERVICE")
               )

               .route("quiz",route-> route.path("/quizsahil/**")
                       .filters(f->f.rewritePath("/quizsahil/?(?<remaining>.*)","/${remaining}"))
                       .uri("lb://QUIZ")
               )
               .build();
    }


}
