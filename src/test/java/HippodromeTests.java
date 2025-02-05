import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.*;
public class HippodromeTests {
    @Test
    public void TestingConstructorHippodromeWhereParameterIsNull() {
        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Hippodrome(null);
        });
        Assertions.assertEquals("Horses cannot be null.", throwable.getMessage());
    }
    @Test
    public void TestingConstructorHippodromeWhereParameterIsEmpty() {
        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Hippodrome(new ArrayList<Horse>());
        });
        Assertions.assertEquals("Horses cannot be empty.", throwable.getMessage());
    }

    @Test
    public void TestingMethodGetHorses() {
        List<Horse> horses = new ArrayList<>(List.of(new Horse("lol", 0.754, 400),
                new Horse("lol", 0.754, 400),
                new Horse("lol", 0.754, 400)));
        Hippodrome hippodrome = new Hippodrome(horses);
        Assertions.assertEquals(horses,hippodrome.getHorses());

    }
    @Test
    public void TestingMethodMoveHorses() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(Mockito.mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();
        for (Horse horse : horses) {
            Mockito.verify(horse).move();
        }
    }
    @Test
    public void TestingMethodGetWinner() {
        List<Horse> horses = new ArrayList<>(List.of(
                new Horse("lol1", 1.00, 500),
                new Horse("lol2", 1.45, 500),
                new Horse("lol3", 1.99, 500)
        ));
        Hippodrome hippodrome = new Hippodrome(horses);
        Horse winner = hippodrome.getHorses().stream()
                .max(Comparator.comparing(Horse::getDistance))
                .get();
        Assertions.assertEquals(winner,hippodrome.getWinner());
    }
}
