import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class MainTests {
    @Test
    @Disabled
    public void MainTimingTest() {
        Assertions.assertTimeout(Duration.ofSeconds(22), () -> {
            Main.main(new String[]{});
        });
    }
}
