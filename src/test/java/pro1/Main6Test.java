package pro1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Main6Test {

    @Test
    public void test() {
        long bestId = Main6.idOfBestTeacher("KIKM", 2024);
        System.out.println("ID nejlepšího učitele: " + bestId);

        assertTrue(bestId > 0, "ID by mělo být kladné číslo (nenalezen = -1)");
    }
}
