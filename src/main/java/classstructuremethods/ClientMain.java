package classstructuremethods;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();
        client.setName("Karsai Endre");
        client.setYear(1978);
        client.setAddress("Budapest");

        System.out.println(client.getName());
        System.out.println(client.getYear());
        System.out.println(client.getAddress());

        client.migrate("Szeged");
        System.out.println("Új cím: " + client.getAddress());

    }

}

