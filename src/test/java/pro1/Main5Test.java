package pro1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Main5Test {

    @Test
    public void test() {
        String result = Main5.roomsSummary("KIKM", 2024);
        System.out.println("Rooms summary: " + result);

        assertNotNull(result, "Výstup nesmí být null");
        assertFalse(result.isEmpty(), "Výstup nesmí být prázdný");
        assertTrue(result.contains("J"), "Výstup by měl obsahovat alespoň jednu učebnu s prefixem 'J'");
    }
}
