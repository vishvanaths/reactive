package com.vish.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(System.out::println);

        // Get the value from the Mono into an integer variable
        Integer integer = ReactiveSources.intNumberMono().block();
        System.out.println("Block : " + integer);
        Optional<Integer> i = ReactiveSources.intNumberMono().blockOptional();
        System.out.println("Block optional : " + i.get());
        System.out.println("Press a key to end");
        System.in.read();
    }

}
