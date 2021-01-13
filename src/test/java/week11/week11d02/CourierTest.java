package week11.week11d02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {


    @Test
    void testAddRide() {
        List<Ride> rideList = new ArrayList<>();
        rideList.add(new Ride(1,1,3));
        rideList.add(new Ride(1,2,31));
        rideList.add(new Ride(3,1,13));
        Courier courier = new Courier(rideList);
        courier.addRide(new Ride(4,1,12));
        assertEquals(3, courier.getRides().get(2).getDay());
        assertEquals(4, courier.getRides().get(3).getDay());
    }

    @Test
    void testWrongRideShouldThrowException() {
        List<Ride> rideList = new ArrayList<>();
        rideList.add(new Ride(1,1,3));
        rideList.add(new Ride(1,2,31));
        rideList.add(new Ride(3,1,13));
        Courier courier = new Courier(rideList);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> courier.addRide(new Ride(3,1,11)));
        assertEquals("Wrong ride", ex.getMessage());
    }

    @Test
    void testNoWorkingDay() {
        List<Ride> rideList = new ArrayList<>();
        rideList.add(new Ride(1,1,3));
        rideList.add(new Ride(1,2,31));
        rideList.add(new Ride(3,1,13));
        Courier courier = new Courier(rideList);
        assertEquals(2, courier.getNoWorkingDay());
    }
}