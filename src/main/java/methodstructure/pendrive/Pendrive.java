package methodstructure.pendrive;

public class Pendrive {
    private String name;
    private int capacity;
    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    public void risePrice(int percent) {
        price *=  (1.0 + percent/100.0);
    }

    public int comparePricePerCapacity(Pendrive pendrive) {
        int better = 0;
        if (getPrice()/getCapacity() > pendrive.getPrice()/pendrive.getCapacity()) {
            better = 1;
        } else if ((double) getPrice()/getCapacity() == (double) pendrive.getPrice()/pendrive.getCapacity()) {
            better = 0;
        } else {
            better = -1;
        }
        return better;
    }

    public boolean cheaperThan(Pendrive pendrive) {
        return getPrice() < pendrive.getPrice();
    }

    @Override
    public String toString() {
        return "Pendrive{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }
}
