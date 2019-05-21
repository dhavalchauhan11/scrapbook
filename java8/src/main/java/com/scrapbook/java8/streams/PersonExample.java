package com.scrapbook.java8.streams;

import java.util.*;
import java.util.stream.Collectors;

public class PersonExample {

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Dhaval", "Chauhan", 35),
                new Person("Bhavya", "Chauhan", 35),
                new Person("John", "Guther", 65),
                new Person("Faize", "Alvarez", 19)

        );

//        terminalOperation(persons);
        collectOperation(persons);


    }

    /**
     * @param persons
     */
    private static void collectOperation(List<Person> persons) {
        // join in comma separated string
        String result =
                persons.stream()
                        .filter(person -> person.getAge() > 2)
                        .map(Person::getLastName)
                        .collect(Collectors.joining(", "));

        System.out.println("String result: " + result);

        // collect in a list
        List<String> resultList =
                persons.stream()
                        .filter(person -> person.getAge() > 10)
                        .map(Person::getFirstName)
                        .collect(Collectors.toList());

        System.out.println("List result: " + resultList);

        // group by ages in a Map with person object
        Map<Integer, List<Person>> resultMap =
                persons.stream()
                        .filter(person -> person.getAge() > 10)
                        .collect(Collectors.groupingBy(Person::getAge));
        System.out.println("Map result: " + resultMap);

        // Pass collector result in downstream collector
        // eg. group by ages but create the map only with the count instead of whole person object
        Map<Integer, Long> resultCountMap =
                persons.stream()
                        .filter(person -> person.getAge() > 10)
                        .collect(
                                Collectors.groupingBy(
                                        Person::getAge,
                                        Collectors.counting()));
        System.out.println("Map with count result: " +resultCountMap);
    }

    /**
     * map - persons ages
     * filter - getAge > 2
     * reduce - min etc...
     *
     * @param persons
     */
    private static void terminalOperation(List<Person> persons) {
        Optional<Integer> minAge =
                persons.stream()
                        .map(person -> person.getAge())
                        .filter(age -> age > 2)
                        .min(Comparator.naturalOrder());

        System.out.println("Minimum age: " + minAge);

    }
}
