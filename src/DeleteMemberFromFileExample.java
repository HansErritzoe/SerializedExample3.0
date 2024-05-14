import java.util.ArrayList;
import java.util.Scanner;

public class DeleteMemberFromFileExample {
    public static void deleteMemberById(String filePath) {
        // Load all members from the file
        ArrayList<Member> members = MemberRepository.readMembers(filePath);

        // Get the member ID to delete from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the member to delete: ");
        int idToDelete = scanner.nextInt();

        // Find and remove the member with the specified ID
        boolean memberFound = false;
        for (Member member : members) {
            if (member.getId() == idToDelete) {
                members.remove(member);
                memberFound = true;
                break;
            }
        }

        if (memberFound) {
            // Write the updated list back to the file
            MemberRepository.writeMembers(members, filePath);
            System.out.println("Member with ID " + idToDelete + " has been deleted.");
            System.out.println();
        } else {
            System.out.println("Member with ID " + idToDelete + " not found.");
        }

        scanner.close();
    }
}
