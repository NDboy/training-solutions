package stringbuilder;

public class NameConcat {
    private String familyName;
    private String midName;
    private String givenName;
    private Title title;

    public NameConcat(String familyName, String midName, String givenName, Title title) {
        if (familyName.isBlank() || givenName.isBlank()) {
            throw new IllegalArgumentException("Family name and given name must not be empty.");
        }
        this.familyName = familyName;
        this.midName = midName;
        this.givenName = givenName;
        this.title = title;
    }

    public String concatNameWesternStyle (Title title, String familyName, String midName, String givenName) {
        StringBuilder allName = new StringBuilder();
        if (title != null || !title.equals("")) {
            allName.append(title.getTitleString());
        }
        allName.append(" " + givenName);
        if (!midName.isBlank()) {
            allName.append(" " + midName);
        }
        allName.append(" " + familyName);

        return allName.toString();
    }

    public String concatNameHungarianStyle (Title title, String familyName, String midName, String givenName) {
        StringBuilder allName = new StringBuilder();

        if (title != null || !title.equals("")) {
            allName.append(title.getTitleString());
        }

        allName.append(" " + familyName);

        if (!midName.isBlank()) {
            allName.append(" " + midName);
        }

        allName.append(" " + givenName);

        return allName.toString();
    }

    public String insertTitle(String name, Title title) {
        name = title.getTitleString().concat(" " + name);
        return name;
    }

    public String deleteNamePart (String name, String delete) {
        StringBuilder allName = new StringBuilder();
        allName.append(name).delete(allName.indexOf(delete), allName.indexOf(delete)+delete.length()+1);
        return allName.toString();
    }


    public static void main(String[] args) {
        NameConcat nameConcat = new NameConcat("Doe", "Jason", "John", Title.MR);
        System.out.println((nameConcat.concatNameWesternStyle(Title.MR, "Doe", "Jason", "John")));
        System.out.println((nameConcat.concatNameHungarianStyle(Title.MR, "Doe", "Jason", "John")));
        System.out.println(nameConcat.insertTitle("John Jason Doe", Title.PROF));
        System.out.println(nameConcat.deleteNamePart("John Jason Doe", "Doe"));
    }

}

