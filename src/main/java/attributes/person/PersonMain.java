package attributes.person;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person("Kovács", "123456");
        Address address = new Address("Hungary", "Budapest", "Köztársaság u. 34.", "1029");
        System.out.println(person.personToString());
        System.out.println(address.addressToString());
        person.moveTo(address);
        System.out.println(person.getAddress());
        person.correctData("Varga", "654321");
        person.moveTo(new Address("Hungary", "Pécs", "Corvin u. 5.", "6500"));
        System.out.println(person.personToString());
        System.out.println(person.getAddress());

    }

}
