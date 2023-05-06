package ru.aston.binarysearch;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTest {

    private static int[] array = {1, 2, 3, 4, 5, 6};

    @Test
    void findValidIndex() {
        int target = 1;
        int expectedIndex = 0;

        int result = BinarySearch.find(array, target);

        assertThat(result).isEqualTo(expectedIndex);
    }

    @Test
    void findNotExistingNumber() {
        int target = 1337;
        int expectedIndex = -1;

        int result = BinarySearch.find(array, target);

        assertThat(result).isEqualTo(expectedIndex);
    }

}