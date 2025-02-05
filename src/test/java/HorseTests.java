import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
public class HorseTests {
    @Test
    public void TestingNameCheckIsNull() {;
        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Horse(null,0.65, 400);
        });
        Assertions.assertEquals("Name cannot be null.", throwable.getMessage());
    }
    @Test
    public void TestingNameCheckIsBlank() {;
        Throwable throwable =Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Horse("",0.65, 400);
        });
        Assertions.assertEquals("Name cannot be blank.", throwable.getMessage());

    }
    @Test
    public void TestingNameCheckIsSpace() {;
        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Horse(" ",0.65, 400);
        });
        Assertions.assertEquals("Name cannot be blank.", throwable.getMessage());
    }
    @Test
    public void TestingSpeedCheckIsNegative() {
        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Horse("lol",-0.65, 400);
        });
        Assertions.assertEquals("Speed cannot be negative.", throwable.getMessage());
    }
    @Test
    public void TestingDistanceCheckIsNegative() {
        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Horse("lol",0.65, -400);
        });
        Assertions.assertEquals("Distance cannot be negative.", throwable.getMessage());
    }
    @Test
    public void TestingMethodGetName() {
        String name = "lol";
        Horse horse = new Horse(name,0.65, 400);
        Assertions.assertEquals(name,horse.getName());
    }
    @Test
    public void TestingMethodGetSpeed() {
        double speed = 0.65;
        Horse horse = new Horse("lol",speed, 400);
        Assertions.assertEquals(speed,horse.getSpeed());
    }
    @Test
    public void TestingMethodGetDistance() {
        double distance = 400;
        Horse horse = new Horse("lol",0.65, distance);
        Assertions.assertEquals(distance,horse.getDistance());
    }
    @Test
    public void TestingConstructorWithoutDistance() {
        Horse horse = new Horse("lol",0.65);
        Assertions.assertEquals(0,horse.getDistance());
    }
    @Test
    public void TestingMethodMove() {
        try (MockedStatic<Horse> mockedHorse = Mockito.mockStatic(Horse.class)) {
            double speed = 0.65;
            double distance = 400;
            mockedHorse.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(1.00);
            Horse horse = new Horse("lol",speed, distance);
            horse.move();
            mockedHorse.verify(() -> Horse.getRandomDouble(0.2, 0.9));
            Assertions.assertEquals(speed+distance,horse.getDistance());
        }
    }

}
