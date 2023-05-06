package ru.aston.sort;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SelectionSortTest {

    private int[] arrayUnderTest = {4, 9, 7, 6, 2, 3};

    @Test
    void selectionSortTest() {
        Sort selectionSort = new SelectionSort();
        int[] arrayCopy = Arrays.copyOf(arrayUnderTest, arrayUnderTest.length);

        selectionSort.sort(arrayUnderTest);
        Arrays.sort(arrayCopy);

        assertArrayEquals(arrayUnderTest, arrayCopy);
    }

    @Test
    void findMinIndex() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        var findMinElemIndexMethod = getFindMinElemIndexMethod();
        int actualResult = (int) findMinElemIndexMethod.invoke(new SelectionSort(), arrayUnderTest, 0, arrayUnderTest.length - 1);

        assertThat(actualResult).isEqualTo(4);
    }

    private static Method getFindMinElemIndexMethod() throws NoSuchMethodException {
        String methodName = "findMinElemIndex";
        Method method = SelectionSort.class
                .getDeclaredMethod(methodName, int[].class, int.class, int.class);
        method.setAccessible(true);
        return method;
    }

}