package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private List<Ship> ships = new ArrayList<>();
    private int waitingPersons;
    private int waitingCargo;


    public List<Ship> getShips() {
        return ships;
    }

    public int getWaitingPersons() {
        return waitingPersons;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }

    public void loadShip(int passengers, int cargoWeight) {
        int passengersPuffer = passengers;
        int cargoWeightPuffer = cargoWeight;

        for (Ship ship : ships) {
            if(ship instanceof CanCarryPassengers) {
                if(passengersPuffer != 0) {
                    passengersPuffer = ((CanCarryPassengers) ship).loadPassenger(passengersPuffer);
                }
            }
            if(ship instanceof CanCarryGoods) {
                if(cargoWeight != 0) {
                    cargoWeightPuffer = ((CanCarryGoods) ship).loadCargo(cargoWeightPuffer);
                }
            }
        }
        waitingPersons = passengersPuffer;
        waitingCargo = cargoWeightPuffer;
    }

    public void addShip(Ship newShip) {
        ships.add(newShip);
    }


}
