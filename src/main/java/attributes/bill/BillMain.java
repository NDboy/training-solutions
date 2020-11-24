package attributes.bill;

public class BillMain {
    public static void main(String[] args) {
        Bill bill = new Bill();

        bill.addItem(new Item("alma", 12, 1.5));
        bill.addItem(new Item("körte", 1, 1.1));
        bill.addItem(new Item("barack", 212, 2.3));

        System.out.println(bill.calculateTotalPrice());


    }
}
