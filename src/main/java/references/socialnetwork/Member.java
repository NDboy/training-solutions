package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private List<Member> connections = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Member> getConnections() {
        return connections;
    }

    public void connectMember(Member member) {
        connections.add(member);

    }
    public List<String> connectedNames() {
        List<String> connNames = new ArrayList<>();
        for (Member member : connections) {
            connNames.add(member.getName());
        }
        return connNames;
    }

    @Override
    public String toString() {
        return name + ": " + connectedNames();
    }

}
