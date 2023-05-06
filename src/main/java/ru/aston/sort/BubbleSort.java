package ru.aston.sort;

public class BubbleSort implements Sort {

    @Override
    public void sort(int[] array, int from, int to) {
        for (int i = 0; i < to; i++) {
            for (int j = 0; j < to - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

}
