package week02.week02d02;

public class Phone {
    private String type;
    private int mem;

    public Phone(String type, int mem) {
        this.type = type;
        this.mem = mem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMem() {
        return mem;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

    public static void main(String[] args) {
        Phone phone = new Phone("Samsung", 32);
        Phone phone2 = new Phone("Huawei", 18);
        System.out.println(phone.getType() + " " + phone.getMem());
        System.out.println(phone2.getType() + " " + phone2.getMem());
    }
}
