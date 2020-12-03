package inheritanceconstructor.cars;

public class Jeep extends Car{

    private double extraCapacity;
    private double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    public double getExtraCapacity() {
        return extraCapacity;
    }

    public double getExtraFuel() {
        return extraFuel;
    }

    public void modifyFuelAmount(double fuel) {
        extraFuel += fuel;
        if (extraFuel < 0) {
            super.modifyFuelAmount(extraFuel);
            extraFuel = 0;
        }
    }

    private double consumedFuel(int km) {
        return super.getFuelRate() * km;
    }

    public void drive(int km) {
        if (consumedFuel(km) > super.getFuel() + extraFuel) {
            throw new IllegalArgumentException("Not enough fuel available!");
        }
        modifyFuelAmount(- consumedFuel(km));
    }

    public double calculateRefillAmount() {
        return getTankCapacity() + extraCapacity - getFuel() - extraFuel;
    }

}
