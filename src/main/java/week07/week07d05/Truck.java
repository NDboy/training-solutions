package week07.week07d05;

public class Truck extends Vehicle{

    public Truck(int numberOfGears, TransmissionType transmissionType) {
        super(numberOfGears, transmissionType);
    }

    @Override
    public int getNumberOfGears() {
        return super.getNumberOfGears();
    }

    @Override
    public TransmissionType getTransmissionType() {
        return super.getTransmissionType();
    }
}
