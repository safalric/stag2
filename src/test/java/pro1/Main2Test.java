package pro1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Main2Test {

    @Test
    public void test() {
        long result = Main2.maxPersonsCount("KIKM", 2024);
        System.out.println("Maximální počet osob: " + result);
        assertTrue(result >= 0, "Výsledek by měl být nezáporný");
    }
}
