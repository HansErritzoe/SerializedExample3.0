import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create an ArrayList of Member objects
        ArrayList<Member> members = new ArrayList<>();
        members.add(new Member(1, "Alice", 30));
        members.add(new CompetitionMember(2, "Bob", 25, "Swimming"));
        members.add(new Member(3, "Charlie", 35));

        // File path for storing member objects
        String filePath = "members.dat";

        // Write members to file
        MemberRepository.writeMembers(members, filePath);

        // Read and print members from file
        ArrayList<Member> readMembers = MemberRepository.readMembers(filePath);
        System.out.println("Members read from file: \n");
        for (Member member : readMembers) {
            System.out.println(member);
        }
        System.out.println();
        //saves to file after updating fields
        MemberRepository.writeMembers(readMembers, filePath);

        // Delete a member by ID method call
        DeleteMemberFromFileExample.deleteMemberById(filePath);

        // Read and print members from file after deletion
        readMembers = MemberRepository.readMembers(filePath);
        System.out.println("Members read from file after deletion: \n");
        for (Member member : readMembers) {
            System.out.println(member);
        }
    }
}
