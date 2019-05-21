package com.scrapbook.java8.streams;

import javax.swing.text.html.Option;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonExampleFromFile {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        try (
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        PersonExample.class.getResourceAsStream("Persons.txt")
                                )
                        );
                Stream<String> stream = reader.lines();

        ) {
            stream.map(line -> {
                String[] s = line.split(" ");
                Person p = new Person(s[0].trim(), s[1].trim(), Integer.parseInt(s[2]));
                persons.add(p);
                return p;
            }).forEach(System.out::println);

        } catch (IOException ioe) {
            ioe.getMessage();
        }

        // youngest
        Optional<Person> opt =
                persons.stream().filter(p -> p.getAge() >= 20)
                .min(Comparator.comparing(Person::getAge));
        System.out.println(opt);

        // older person
        Optional opt2 =
                persons.stream()
                .filter(p -> p.getAge() > 10)
                .max(Comparator.comparing(Person::getAge));
        System.out.println(opt2);

        // Persons group by their age
        Map<Integer, List<Person>> map =
        persons.stream()
                .collect(
                        Collectors.groupingBy(Person::getAge));
        System.out.println("Map: " +map);

        // Collect age groups by counts
        Map<Integer,Long> map2 =
        persons.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge,
                                Collectors.counting()));
        System.out.println("Map2: " +map2);

        // collect by name
        Map<Integer,List<String>> map3 =
        persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getAge,
                        Collectors.mapping(
                                Person::getFirstName,
                                Collectors.toList())
                ));

        System.out.println("Map3: " +map3);

        // collect by name - sorted
        Map<Integer,Set<String>> map4 =
                persons.stream()
                        .collect(Collectors.groupingBy(
                                Person::getAge,
                                Collectors.mapping(
                                        Person::getFirstName,
                                        Collectors.toCollection(TreeSet::new))
                        ));

        System.out.println("Map4: " +map4);

    }
}
