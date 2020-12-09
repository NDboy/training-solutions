package virtualmethod.vehicle;

public class FerryBoat extends Vehicle{
    public static final int MAX_CARRY_WEIGHT = 2000;
    private Car car;

    public FerryBoat(int vehicleWeight) {
        super(vehicleWeight);
    }

    public static int getMaxCarryWeight() {
        return MAX_CARRY_WEIGHT;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() + car.getGrossLoad();
    }

    public boolean canCarry(Car car) {
        return car.getVehicleWeight() < MAX_CARRY_WEIGHT;
    }

    public boolean load(Car car) {
        if (canCarry(car)) {
            this.car = car;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "FerryBoat{" +
                "car=" + car +
                '}';
    }
}
