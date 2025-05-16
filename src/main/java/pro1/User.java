package pro1;

import java.io.*;
import java.util.List;

public class User {
    public String firstName;
    public String surname;
    public int id;

    public User(String firstName, String surname, int id) {
        this.firstName = firstName;
        this.surname = surname;
        this.id = id;
    }

    public static void binaryExample() throws IOException {
        List<User> data = List.of(
                new User("Jan", "Kubík", 56455),
                new User("Oldřich", "Jarolím", 8545)
        );

        try (DataOutputStream s = new DataOutputStream(new FileOutputStream("so.ubor"))) {
            for (User u : data) {
                s.writeUTF(u.firstName);
                s.writeUTF(u.surname);
                s.writeInt(u.id);
            }
        }

        try (DataInputStream s2 = new DataInputStream(new FileInputStream("so.ubor"))) {
            while (s2.available() > 0) {
                String firstName = s2.readUTF();
                String surname = s2.readUTF();
                int id = s2.readInt();
                System.out.println(firstName + " " + surname + " " + id);
            }
        }
    }
}
