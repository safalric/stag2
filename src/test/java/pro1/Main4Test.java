package pro1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Main4Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void test01() {
        Main4.printShortestEmails("KIKM", 5);
        String output = outContent.toString().trim();
        String[] lines = output.split("\\R"); // rozdělí na řádky

        System.out.println("Výstup:");
        System.out.println(output);

        assertEquals(5, lines.length, "Očekává se 5 e-mailů");
        for (String email : lines) {
            assertTrue(email.contains("@"), "Řádek neobsahuje platný e-mail: " + email);
        }
    }
}
