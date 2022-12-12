package com.vish.reactiveweb;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FluxAndMonoTest {
    private Flux<String> stringFlux = Flux.just("java", "spring", "spring boot", "flux");

    private Mono<String> stringMono = Mono.just("java");

    @Test
    public void test_flux(){
        Flux<String> currFlux = stringFlux.concatWith(Flux.error(new RuntimeException("Error in flux")))
                                          .concatWith(Flux.just("After error"));

        currFlux.log()
                .subscribe(System.out::println,
                        err -> System.out.println("Exception: " + err.getMessage()),
                        () -> System.out.println("Completed"));
    }

    @Test
    public void test_flux_step_verify(){

        StepVerifier.create(stringFlux)
                .expectNext("java", "spring", "spring boot", "flux")
                .verifyComplete();
    }

    @Test
    public void test_mono(){

        StepVerifier.create(stringMono)
                .expectNext("java")
                .verifyComplete();
    }

    @Test
    public void test_mono_error(){

        StepVerifier.create(Mono.error(new RuntimeException("Mono error occured")))
                .expectError(RuntimeException.class)
                .verify();
    }
}
