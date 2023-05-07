package ru.aston.bfs.graph;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

@ToString
@Getter
@Setter
@EqualsAndHashCode(of = "name")
public class Person {

    private final String name;
    private final List<Person> neighbours;
    private boolean sellingMango;

    public Person(String name) {
        this.name = name;
        neighbours = new ArrayList<>();
    }

    public static Optional<Person> searchForFirstMangoSeller(Person rootPerson) {
        Queue<Person> queue = new ArrayDeque<>();
        Set<Person> checkedPersons = new HashSet<>();

        queue.add(rootPerson);

        while (!queue.isEmpty()) {
            var currentPerson = queue.remove();
            if (!checkedPersons.contains(currentPerson)) {
                if (currentPerson.isMangoSeller()) {
                    return Optional.of(currentPerson);
                } else {
                    queue.addAll(currentPerson.getNeighbours());
                }
                checkedPersons.add(currentPerson);
            }
        }

        return Optional.empty();
    }

    public void addNeighbour(Person... persons) {
        neighbours.addAll(List.of(persons));
    }

    private boolean isMangoSeller() {
        return sellingMango;
    }

}


