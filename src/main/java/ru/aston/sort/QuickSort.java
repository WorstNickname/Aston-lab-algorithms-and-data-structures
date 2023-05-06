package ru.aston.sort;

import java.util.Random;

public class QuickSort implements Sort {

    private final Random random;

    public QuickSort() {
        random = new Random(1337);
    }

    @Override
    public void sort(int[] array, int from, int to) {
        if (from < to) {
            int leftPointer = partition(array, from, to);

            sort(array, from, leftPointer - 1);
            sort(array, leftPointer + 1, to);
        }
    }

    private int partition(int[] array, int from, int to) {
        int randomPivotIndex = chooseRandomPivotIndex(array, from, to);

        swap(array, randomPivotIndex, to);

        int pivot = array[to];
        int leftPointer = from;
        int rightPointer = to;

        while (leftPointer < rightPointer) {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, to);

        return leftPointer;
    }

    private int chooseRandomPivotIndex(int[] array, int from, int to) {
        return random.nextInt(to - from) + from;
    }

}
