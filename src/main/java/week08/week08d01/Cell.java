package week08.week08d01;

public class Cell {
    private int cellNumber;
    private DoorStatus doorStatus;

    public Cell(int cellNumber, DoorStatus doorStatus) {
        this.cellNumber = cellNumber;
        this.doorStatus = doorStatus;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    public void changeDoorStatus() {
        doorStatus = doorStatus.change();
    }

    @Override
    public String toString() {
        return cellNumber + " " + doorStatus;
    }
}
