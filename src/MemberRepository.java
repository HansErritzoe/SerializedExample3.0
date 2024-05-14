import java.io.*;
import java.util.ArrayList;

public class MemberRepository {

    // Static method to write an ArrayList of Member objects to a file
    public static void writeMembers(ArrayList<Member> members, String filePath) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
            for (Member member : members) {
                oos.writeObject(member); // Serialize each Member object and write to the file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Static method to read Member objects from a file into an ArrayList
    public static ArrayList<Member> readMembers(String filePath) {
        ArrayList<Member> members = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
            while (true) {
                try {
                    Member member = (Member) ois.readObject(); // Deserialize a Member object from the file
                    members.add(member); // Add the deserialized object to the ArrayList
                } catch (EOFException e) {
                    // End of file reached, break out of the loop
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return members; // Return the list of deserialized Member objects
    }
}
