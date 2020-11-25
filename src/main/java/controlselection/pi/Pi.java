package controlselection.pi;

public class Pi {
    private  static final String ABC = "aábcdeéfghiíjklmnyoóöőpqrstuúüűvwxyz";

    public String piMaker(String str) {
        str = str.toLowerCase();
        int counter = 0;
        String piNums = "";
        boolean onOff = false;
        for (int i = 0; i < str.length(); i++) {
            if (ABC.contains(String.valueOf(str.charAt(i)))) {
                counter++;
            } else if ((!ABC.contains(String.valueOf(str.charAt(i)))) && counter != 0) {
                piNums = piNums.concat(String.valueOf(counter));
                if (onOff == false) {
                    piNums = piNums.concat(".");
                    onOff = true;
                }
                counter = 0;
            }
        }
        return piNums;
    }

    public static void main(String[] args) {
        Pi pi = new Pi();
        System.out.println(pi.piMaker("Nem a régi s durva közelítés,\n" +
                "Mi szótól szóig így kijön\n" +
                "Betűiket számlálva.\n" +
                "Ludolph eredménye már,\n" +
                "Ha itt végezzük húsz jegyen.\n" +
                "De rendre kijő még tíz pontosan,\n" +
                "Azt is bízvást ígérhetem."));
    }
}
