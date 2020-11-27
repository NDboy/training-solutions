package algorithmssum;

import java.util.ArrayList;
import java.util.List;

public class SalesAmountSumCalculator {

    private List<Salesperson> salesPersonList = new ArrayList<>();


    public int sumSalesAmount(List<Salesperson> salesPersonList) {
        int sum = 0;
        for (Salesperson salesPerson: salesPersonList){
            sum += salesPerson.getAmount();
        }
        return sum;
    }



}
