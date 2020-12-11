package week07.week07d05;

public class Car extends Vehicle{

    public Car(int numberOfGears) {
        super(numberOfGears, TransmissionType.AUTOMATIC);
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
