package week14.week14d04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContractCreatorTest {

    private List<Integer> monthlyPrices = new ArrayList<>();

    @BeforeEach
    void init() {
        for (int i = 1; i <= 12; i++) {
            monthlyPrices.add(i * 10_000);
        }
    }

    @Test
    void testCreate() {
        ContractCreator contractCreator = new ContractCreator("John Doe", monthlyPrices);
        Contract johnContract = contractCreator.getContract();
        assertEquals("John Doe", johnContract.getClient());
        assertEquals(120_000, johnContract.getMonthlyPrices().get(11));
        johnContract.getMonthlyPrices().set(11, 100_000);
        assertEquals(120_000, johnContract.getMonthlyPrices().get(11));

        Contract jackContract = contractCreator.create("Jack Doe");
        jackContract.getMonthlyPrices().set(11, 100_000);
        assertEquals("Jack Doe", jackContract.getClient());
        assertEquals(120_000, jackContract.getMonthlyPrices().get(11));
        assertEquals("John Doe", johnContract.getClient());
    }


}