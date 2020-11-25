package week05.week05d03;

import org.junit.jupiter.api.Test;
import week05.week05d03.ListCounter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListCounterTest {

    @Test
    public void wordCounterByATest() {
        ListCounter listCounter = new ListCounter();
        List<String> testList = Arrays.asList("alma", "körte", "ananász");

        assertEquals(2, listCounter.wordCounterByA(testList));
    }

    @Test
    public void wordCounterByAEmptyListTest() {
        ListCounter listCounter = new ListCounter();
        List<String> testList = new ArrayList<>();

        assertEquals(0, listCounter.wordCounterByA(testList));
    }

    @Test
    public void wordCounterByANonAListTest() {
        ListCounter listCounter = new ListCounter();
        List<String> testList = Arrays.asList("balma", "körte", "bananász");

        assertEquals(0, listCounter.wordCounterByA(testList));
    }

}
