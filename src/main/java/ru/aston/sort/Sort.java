package ru.aston.sort;

public interface Sort {

    void sort(int[] array, int from, int to);

    default void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    default void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

}
