package week11.week11d02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RideTest {

    Ride ride = new Ride(2, 2, 18);


    @Test
    void testGetDay() {
        assertEquals(2, ride.getDay());
    }

    @Test
    void testGetRideNumber() {
        assertEquals(2, ride.getRideNumber());
    }

    @Test
    void testGetKm() {
        assertEquals(18, ride.getKm());
    }
}