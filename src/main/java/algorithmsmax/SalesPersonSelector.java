package algorithmsmax;

import java.util.List;

public class SalesPersonSelector {

    public SalesPerson selectSpMax(List<SalesPerson> salesPersonList) {
        SalesPerson salesPeopleMaxAmount = null;
        for (SalesPerson salesPerson: salesPersonList) {
            if (salesPeopleMaxAmount == null || salesPerson.getAmount() > salesPeopleMaxAmount.getAmount()) {
                salesPeopleMaxAmount = salesPerson;
            }
        }
        return salesPeopleMaxAmount;
    }


    public SalesPerson selectSpOverMax(List<SalesPerson> salesPersonList) {
        SalesPerson salesPeopleOverMaxAmount = null;
        for (SalesPerson salesPerson: salesPersonList) {
            if (salesPeopleOverMaxAmount == null || salesPerson.getAmount() - salesPerson.getTargetAmount() > salesPeopleOverMaxAmount.getAmount() - salesPeopleOverMaxAmount.getTargetAmount()) {
                salesPeopleOverMaxAmount = salesPerson;
            }
        }
        return salesPeopleOverMaxAmount;
    }


    public SalesPerson selectSpLessMax(List<SalesPerson> salesPersonList) {
        SalesPerson salesPeopleLessMaxAmount = null;
        for (SalesPerson salesPerson: salesPersonList) {
            if (salesPeopleLessMaxAmount == null || salesPerson.getAmount() - salesPerson.getTargetAmount() < salesPeopleLessMaxAmount.getAmount() - salesPeopleLessMaxAmount.getTargetAmount()) {
                salesPeopleLessMaxAmount = salesPerson;
            }
        }
        return salesPeopleLessMaxAmount;
    }


}
