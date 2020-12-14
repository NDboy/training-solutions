package week08.week08d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {


    @Test
    public void testCreate() {
        assertEquals("x= 0, y= 0", new Robot(new Position(0,0)).getPosition().toString());
    }

    @Test
    public void testMove() {
        assertEquals("x= -6, y= -6", new Robot(new Position(0,0)).move("FFBBBLLLJLLLBBBBFLLL").toString());
        assertEquals("x= -4, y= 0", new Robot(new Position(0,0)).move("FFBBBLLLJLLLFFFFFFBBFLLL").toString());
    }

    @Test
    public void wrongParameterShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Robot(new Position(0,0)).move("FFBBBLxLLJLLLFFFFFFBBFLLL"));
        assertEquals("Wrong parameter!", ex.getMessage());


    }




}