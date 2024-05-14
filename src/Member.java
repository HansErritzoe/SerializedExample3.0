import java.io.Serializable;
import java.io.*;
import java.util.*;

public class Member implements Serializable {
    private static final long serialVersionUID = 2L; // Unique identifier for Serializable classes, update when class gets updated with new fields
    private int id;
    private String name;
    private int age;
    private String email; //new field

    public Member(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Custom readObject method to handle data migration, automatically called upon by java when deserializing objects
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        if (email == null) {  // Prompt user for email if it's null
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter email for " + name + ": ");
            this.email = scanner.nextLine();
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //new toString()
    @Override
    public String toString() {
        return "Member{id=" + id + ", name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}

