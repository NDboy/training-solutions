package isahasa.fleet;

public class CanCarryGoodsBehaviour implements CanCarryGoods{
    private int cargoWeight;
    private int maxCargoWeight;

    public CanCarryGoodsBehaviour(int cargoWeight, int maxCargoWeight) {
        this.cargoWeight = cargoWeight;
        this.maxCargoWeight = maxCargoWeight;
    }

    public CanCarryGoodsBehaviour(int maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }

    @Override
    public int loadCargo(int weight) {
        if (weight >= maxCargoWeight) {
            cargoWeight = maxCargoWeight;
            return weight - maxCargoWeight;
        } else {
            cargoWeight = weight;
            return 0;
        }
    }


    @Override
    public int getCargoWeight() {
        return cargoWeight;
    }
}
