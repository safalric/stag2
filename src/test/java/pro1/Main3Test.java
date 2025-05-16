package pro1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Main3Test {

    @Test
    public void test() {
        String email = Main3.emailOfBestTeacher("KIKM", 2024);
        System.out.println("Nejlepší učitel (e-mail): " + email);

        assertNotNull(email, "E-mail nesmí být null");
        assertTrue(email.contains("@"), "E-mail musí obsahovat '@'");
        assertTrue(email.length() > 5, "E-mail je podezřele krátký");
    }
}
