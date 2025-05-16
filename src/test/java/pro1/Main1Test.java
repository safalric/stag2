package pro1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Main1Test {

    @Test
    public void test() {
        long result = Main1.emptyActionsCount("KIKM", 2024);
        System.out.println("Počet prázdných akcí: " + result);
        assertTrue(result >= 0, "Výsledek by měl být nezáporný");
    }
}
