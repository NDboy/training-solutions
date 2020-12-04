package inheritancemethods.products;

import java.math.BigDecimal;

public class PackedProduct extends Product{
    private int packingUnit;
    private BigDecimal weightOfBox;

//    public PackedProduct(String name, BigDecimal unitWeight, int packingUnit, BigDecimal weightOfBox) {
//        super(name, unitWeight);
//        this.packingUnit = packingUnit;
//        this.weightOfBox = weightOfBox;
//    }

    public PackedProduct(String name, BigDecimal unitWeight, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeight, numberOfDecimals);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    public int getPackingUnit() {
        return packingUnit;
    }

    public BigDecimal getWeightOfBox() {
        return weightOfBox;
    }

    private BigDecimal neededPackagesWeight(int pieces) {
        int pcs = 0;
        if (pieces % packingUnit == 0) {
            pcs = pieces / packingUnit;
        } else {
            pcs = pieces / packingUnit + 1;
        }
        return new BigDecimal(pcs).multiply(weightOfBox).setScale(getNumberOfDecimals());
    }


    @Override
    public BigDecimal totalWeight(int pieces) {
        return super.totalWeight(pieces).add(neededPackagesWeight(pieces));

    }
}
