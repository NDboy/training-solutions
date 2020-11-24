package references.parameters;

public class ReferencesMain {
    public static void main(String[] args) {
        Person person1 = new Person("Jack", 45);
        Person person2 = person1;
        person2.setName("Jason");
        System.out.println(person1);
        System.out.println(person2);

        int i = 24;
        int j = i;
        j++;
        System.out.println(i + " " + j);
        person1 = new Person("Jacob", 54);
        System.out.println(person1);



    }
}
