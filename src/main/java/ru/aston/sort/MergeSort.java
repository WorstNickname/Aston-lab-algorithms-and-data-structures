package ru.aston.sort;

public class MergeSort implements Sort {

    @Override
    public void sort(int[] array, int from, int to) {
        int length = to - from + 1;

        if (from < to) {
            int midIndex = length / 2;

            int[] leftHalf = getLeftHalf(array, midIndex);
            int[] rightHalf = getRightHalf(array, length, midIndex);

            sort(leftHalf);
            sort(rightHalf);

            merge(array, leftHalf, rightHalf);
        }

    }

    private static int[] getLeftHalf(int[] array, int midIndex) {
        int[] leftHalf = new int[midIndex];
        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = array[i];
        }
        return leftHalf;
    }

    private static int[] getRightHalf(int[] array, int length, int midIndex) {
        int[] rightHalf = new int[length - midIndex];
        for (int i = midIndex; i < length; i++) {
            rightHalf[i - midIndex] = array[i];
        }
        return rightHalf;
    }

    private void merge(int[] array, int[] leftHalf, int[] rightHalf) {
        int leftLength = leftHalf.length;
        int rightLength = rightHalf.length;

        int mergedArrayPointer = 0;
        int leftHalfPointer = 0;
        int rightHalfPointer = 0;

        while (leftHalfPointer < leftLength && rightHalfPointer < rightLength) {
            if (leftHalf[leftHalfPointer] <= rightHalf[rightHalfPointer]) {
                array[mergedArrayPointer] = leftHalf[leftHalfPointer];
                leftHalfPointer++;
            } else {
                array[mergedArrayPointer] = rightHalf[rightHalfPointer];
                rightHalfPointer++;
            }
            mergedArrayPointer++;
        }

        while (leftHalfPointer < leftLength) {
            array[mergedArrayPointer] = leftHalf[leftHalfPointer];
            mergedArrayPointer++;
            leftHalfPointer++;
        }

        while (rightHalfPointer < rightLength) {
            array[mergedArrayPointer] = rightHalf[rightHalfPointer];
            mergedArrayPointer++;
            rightHalfPointer++;
        }
    }

}
