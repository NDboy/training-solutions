package covid;

public class ZipCode {
    private int code;
    private String city_name;

    public ZipCode(int code, String city_name) {
        this.code = code;
        this.city_name = city_name;
    }

    public ZipCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getCity_name() {
        return city_name;
    }

    @Override
    public String toString() {
        return code + " " + city_name;
    }
}
