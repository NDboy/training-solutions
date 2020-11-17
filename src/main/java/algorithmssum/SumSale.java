package algorithmssum;

import java.util.ArrayList;
import java.util.List;

public class SumSale {



    public int saleSum (List<SalesPerson> salesPersonList) {
        int sum = 0;
        for (SalesPerson salesPerson: salesPersonList){
            sum += salesPerson.getAmount();
        }
        return sum;
    }

    public static void main(String[] args) {
        List <SalesPerson> salesPersonList = new ArrayList<>();
        salesPersonList.add(new SalesPerson("Jack", 200_000));
        salesPersonList.add(new SalesPerson("Jason", 350_000));
        salesPersonList.add(new SalesPerson("John", 511_000));
        System.out.println(new SumSale().saleSum(salesPersonList));

    }

}
