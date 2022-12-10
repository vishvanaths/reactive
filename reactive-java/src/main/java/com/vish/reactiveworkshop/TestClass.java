package com.vish.reactiveworkshop;

import java.util.*;
import java.util.stream.Collectors;
import java.text.Normalizer;

public class TestClass {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("mango");
        fruits.add("apple");
        fruits.add("mango");
        fruits.add("banana");

        System.out.println(fruits.stream().collect(Collectors.groupingBy(s -> s,  Collectors.counting())));
    }
}

