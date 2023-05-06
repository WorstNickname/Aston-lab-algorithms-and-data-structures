package ru.aston.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortTest {

    private int[] arrayUnderTest = {4, 9, 7, 6, 2, 3};

    @Test
    void quickSortTest() {
        Sort quickSort = new QuickSort();
        int[] arrayCopy = Arrays.copyOf(arrayUnderTest, arrayUnderTest.length);

        quickSort.sort(arrayUnderTest);
        Arrays.sort(arrayCopy);

        assertArrayEquals(arrayUnderTest, arrayCopy);
    }
}