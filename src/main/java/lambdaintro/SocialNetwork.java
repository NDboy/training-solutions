package lambdaintro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SocialNetwork {

    private List<Member> members;

    public SocialNetwork(List<Member> members) {
        this.members = members;
    }

    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }

    public List<Member> findMembersBy(Predicate<Member> condition) {
        List<Member> filteredMembers = new ArrayList<>();
        for (Member member : members) {
            if (condition.test(member)) {
                filteredMembers.add(member);
            }
        }
        return filteredMembers;
    }

    public void applyToSelectedMembers(Predicate<Member> condition, Consumer<Member> consumer) {
        for (Member member : members) {
            if (condition.test(member)) {
                consumer.accept(member);
            }
        }
    }

    public List<String> transformMembers(Function<Member, String> function) {
        List<String> processedList = new ArrayList<>();
        for (Member member : members) {
            processedList.add(function.apply(member));
        }
        return processedList;
    }

}
