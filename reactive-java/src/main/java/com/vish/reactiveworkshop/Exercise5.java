package com.vish.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumberMono().subscribe(System.out::println, err -> System.out.println(err.getMessage()), () -> System.out.println("Complete event"));
        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.userMono().subscribe(new UserBaseSubscriber());

        System.out.println("Press a key to end");
        System.in.read();
    }

    private static class UserBaseSubscriber<T> extends BaseSubscriber<T> {
        @Override
        protected void hookOnSubscribe(Subscription subscription) {
            super.hookOnSubscribe(subscription);
            System.out.println("I am subscribed");
            request(1);
        }

        @Override
        protected void hookOnNext(T value) {
            super.hookOnNext(value);
            System.out.println(value);
            request(1);
        }

        @Override
        protected void hookOnComplete(){
            System.out.println("Custom subscriber done");
        }
    }
}