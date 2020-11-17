package controlselection.greetings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingsTest {
    @Test
    public void testSayGreeting() {
        Greetings greetings = new Greetings(15,15);

        assertEquals("Jó éjt!", greetings.findGreeting(4,5));
        assertEquals("Jó reggelt!", greetings.findGreeting(5,5));
        assertEquals("Jó reggelt!", greetings.findGreeting(8,5));
        assertEquals("Jó napot!", greetings.findGreeting(12,0));
        assertEquals("Jó estét!", greetings.findGreeting(19,59));
        assertEquals("Jó éjt!", greetings.findGreeting(20,0));
        assertEquals("Jó éjt!", greetings.findGreeting(20,1));



    }


}
