package com.vish.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        System.out.println("Print all numbers in the intNumbersStream stream:");
        StreamSources.intNumbersStream().forEach(i -> System.out.print(i + " "));

        // Print numbers from intNumbersStream that are less than 5
        System.out.println("\nPrint numbers from intNumbersStream that are less than 5:");
        StreamSources.intNumbersStream().filter(n -> n<5).forEach(i -> System.out.print(i + " "));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("\nPrint the second and third numbers in intNumbersStream that's greater than 5:");
        StreamSources.intNumbersStream().filter(n -> n>5).forEach(i -> System.out.print(i + " "));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println("\nPrint the first number in intNumbersStream that's greater than 5:");
//        StreamSources.intNumbersStream()

        // Print first names of all users in userStream
        System.out.println("\nPrint first names of all users in userStream");
        StreamSources.userStream().forEach(user -> System.out.print(user.getFirstName() + " "));

        // Print first names in userStream for users that have IDs from number stream
        System.out.println("\nPrint first names in userStream for users that have IDs from number stream");
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().filter(integer -> integer == user.getId()).count() > 0)
                .forEach(user -> System.out.print(user.getFirstName() + ","));

        System.out.println("");

    }

}
