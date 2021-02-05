package week14.week14d04;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Contract {
    private String client;
    private List<Integer> monthlyPrices;

    public Contract(String client, List<Integer> monthlyPrices) {
        this.client = client;
        this.monthlyPrices = monthlyPrices;
    }

    public String getClient() {
        return client;
    }

    public List<Integer> getMonthlyPrices() {
        return new ArrayList<>(monthlyPrices);
    }

}


