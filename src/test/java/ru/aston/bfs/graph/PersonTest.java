package ru.aston.bfs.graph;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    @Test
    void seller_exists() {
        var you = new Person("You");
        var bob = new Person("Bob");
        var alise = new Person("Alise");
        var claire = new Person("Claire");
        var anuj = new Person("Anuj");
        var peggy = new Person("Peggy");
        var thom = new Person("Thom");
        var johny = new Person("Johny");

        thom.setSellingMango(true);

        you.addNeighbour(alise, bob, claire);
        bob.addNeighbour(anuj, peggy);
        alise.addNeighbour(peggy);
        claire.addNeighbour(thom, johny);

        var mayBeMangoSeller = Person.searchForFirstMangoSeller(you);

        assertThat(mayBeMangoSeller).isPresent();
        assertThat(mayBeMangoSeller).get().isEqualTo(thom);
    }

    @Test
    void seller_does_not_exist() {
        var you = new Person("You");
        var bob = new Person("Bob");
        var alise = new Person("Alise");
        var claire = new Person("Claire");
        var anuj = new Person("Anuj");
        var peggy = new Person("Peggy");
        var thom = new Person("Thom");
        var johny = new Person("Johny");

        you.addNeighbour(alise, bob, claire);
        bob.addNeighbour(anuj, peggy);
        alise.addNeighbour(peggy);
        claire.addNeighbour(thom, johny);

        var mayBeMangoSeller = Person.searchForFirstMangoSeller(you);

        assertThat(mayBeMangoSeller).isEmpty();
    }

}