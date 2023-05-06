package ru.aston.sort;

public class SelectionSort implements Sort {

    @Override
    public void sort(int[] array, int from, int to) {
        for (int i = 0; i <= to; i++) {
            int minIndex = findMinElemIndex(array, i, to);
            swap(array, i, minIndex);
        }
    }

    private int findMinElemIndex(int[] array, int from, int to) {
        int min = from;
        for (int i = from; i <= to; i++) {
            if (array[i] <= array[min]) {
                min = i;
            }
        }
        return min;
    }

}
