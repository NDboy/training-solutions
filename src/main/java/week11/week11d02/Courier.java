package week11.week11d02;

import java.util.List;

public class Courier {
    private List<Ride> rides;

    public Courier(List<Ride> rides) {
        this.rides = rides;
    }

    public List<Ride> getRides() {
        return rides;
    }

    private boolean isLaterRide(Ride ride) {
        boolean isLater = false;
        Ride lastRide = rides.get(rides.size() - 1);
        if (lastRide.getDay() < ride.getDay() || (lastRide.getDay() == ride.getDay() && lastRide.getRideNumber() < ride.getRideNumber())) {
            isLater = true;
        } else {
            throw new IllegalArgumentException("Wrong ride");
        }
        return isLater;
    }

    public void addRide(Ride ride) {
        if (rides.size() == 0 || isLaterRide(ride)) {
            rides.add(ride);
        }
    }

    public int getNoWorkingDay() {
        for (int i = 1; i < 8; i++) {
            boolean found = false;
            for (Ride ride: rides) {
                if (ride.getDay() == i) {
                    found = true;
                }
            }
            if (!found) {
                return i;
            }
        }
        return 0;
    }

}


//    A feladatban egy biciklis futár egy heti munkáját rögzítjük és készítünk statissztikákat.
//
//        A futár minden fuvar után feljegyzi, hogy a hét hányadik napján történt a fuvar.
//        Ezután azt, hogy az adott nap hányadik fuvarját teljesítette és ezután azt, hogy hány kilométer volt az adott fuvar.
//        A futár egy-egy fuvarját reprezentálja a Ride nevű osztály, adatagokkal, konstruktorra, getterekkel.
//        Készítsd el a Courier osztályt. Ez fogja a futárt reprezentálni. Legyen egy rides listája ami fuvarokat tárol.

//        Legyen egy addRide metódus, ami csak sorrendben enged hozzáadni elemeket a listához.
//        Figyeljünk viszont arra, hogy nem feltétlenül minden nap dolgozott a futár, de ha már bekerült egy 3. napi fuvar,
//        akkor ne kerülhessen be egy 2. napi. És arra is figyelj, hogy a napon belül is sorrendben kerüljenek be az adatok.
//        Ha a paraméterül kapott Ride nem felel meg a feltételeknek dobjunk IllegalArgumentException-t.
//
//        pl egy helyes listára: 1 1 12 1 2 11 2 1 10 4 1 19
//
//        Készíts egy metódust, ami visszad egy napot amikor a futár nem dolgozott. Ha több ilyen nap is van akkor a korábbit!
