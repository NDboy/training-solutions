package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    private List<Member> members = new ArrayList<>();

    public void addMember(String name) {
        members.add(new Member(name));
    }

    private Member findByName(String name) {
        Member mem = null;
        for (Member member : members) {
            if (name.equals(member.getName())) {
                mem = member;
            }
        }
        return mem;
    }


    public void connect(String name, String otherName) {

        findByName(name).connectMember(findByName(otherName));
    }

    public List<String> bidirectionalConnections() {
        List<String> bidi = new ArrayList<>();
        for (Member member: members) {
            for (Member connection: member.getConnections()) {
                if (members.contains(connection)) {
                    bidi.add(member.getName() + " - " + connection.getName());
                }
            }
        }
        return bidi;
    }

    @Override
    public String toString() {
        return members.toString();
    }
}
