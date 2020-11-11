package controlselection.week;

public class DayOfWeeks {
    private String day;

    public DayOfWeeks() {
        this.day = day;
    }

    public String getTypeOfDay(String day) {
        switch (day.toLowerCase()) {
            case "hétfő":
                return "hét eleje";
            case "kedd", "szerda", "csütörtök":
                return "hét közepe";
            case "péntek":
                return "majdnem hétvége";
            case "szombat", "vasárnap":
                return "hétvége";
            default:
                throw new IllegalArgumentException("Invalid day: " + day);
        }
    }

    public static void main(String[] args) {
        System.out.println(new DayOfWeeks().getTypeOfDay("vasárnap"));
    }

}
