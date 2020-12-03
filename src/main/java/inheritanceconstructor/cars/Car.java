package inheritanceconstructor.cars;

public class Car {
    private double fuelRate;
    private double fuel;
    private double tankCapacity;

    public Car(double fuelRate, double fuel, double tankCapacity) {
        if(fuel > tankCapacity) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.fuelRate = fuelRate / 100.0;
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public double getFuel() {
        return fuel;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void modifyFuelAmount(double fuel) {
        this.fuel += fuel;
    }

    private double consumedFuel(int km) {
        return fuelRate * km;
    }

    public void drive(int km) {
        if (consumedFuel(km) > fuel) {
            throw new IllegalArgumentException("Not enough fuel available!");
        }
        modifyFuelAmount(- consumedFuel(km));
    }

    public double calculateRefillAmount() {
        return tankCapacity - fuel;
    }

}
