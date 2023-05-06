package ru.aston.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    private int[] arrayUnderTest = {4, 9, 7, 6, 2, 3};

    @Test
    void mergeSortTest() {
        Sort mergeSort = new MergeSort();
        int[] arrayCopy = Arrays.copyOf(arrayUnderTest, arrayUnderTest.length);

        mergeSort.sort(arrayUnderTest);
        Arrays.sort(arrayCopy);

        assertArrayEquals(arrayUnderTest, arrayCopy);
    }
}