package stringbuilder;

public class NameBuilder {


    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }


    public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        StringBuilder fullName = new StringBuilder();
        if (title != null) {
            fullName.append(title.getTitleString() + " ");
        }
        fullName.append(givenName.trim() + " ");
        if (!isEmpty(middleName)) {
            fullName.append(middleName.trim() + " ");
        }
        fullName.append(familyName.trim());
        return fullName.toString();
    }


    public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        StringBuilder fullName = new StringBuilder();
        if (title != null) {
            fullName.append(title.getTitleString() + " ");
        }
        fullName.append(familyName.trim() + " ");
        if (!isEmpty(middleName)) {
            fullName.append(middleName.trim() + " ");
        }
        fullName.append(givenName.trim());
        return fullName.toString();
    }


    public String insertTitle(String name, Title title, String where) {
        if (isEmpty(name) || isEmpty(title.getTitleString())) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        StringBuilder newName = new StringBuilder(name.trim());

        if (newName.indexOf(where) > 0) {
            return newName.insert(newName.indexOf(where)+1, title.getTitleString() + " ").toString();
        }
        return newName.insert(newName.indexOf(where), title.getTitleString() + " ").toString();
    }


    public String deleteNamePart(String name, String delete) {
        if (isEmpty(name) || isEmpty(delete)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        StringBuilder newName = new StringBuilder(name.trim());

        return newName.delete(newName.indexOf(delete), newName.indexOf(delete) + delete.length()).toString();
    }
}
