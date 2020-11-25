package stringmethods.filename;

public class FileNameManipulator {
    private String fileName;


    public FileNameManipulator() {
        this.fileName = fileName;
    }


    public char findLastCharacter(String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException("Empty string!");
        } else {
            return str.trim().charAt(str.trim().length()-1);
        }
    }

    public String findFileExtension(String fileName) {
        if (isEmpty(fileName) || fileName.indexOf(".") < 1) {
            throw new IllegalArgumentException("Invalid file name!");
        }
        return fileName.trim().substring(fileName.indexOf("."));
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        if (isEmpty(ext) || isEmpty(fileName) || fileName.indexOf(".") < 1) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        return fileName.trim().endsWith("." + ext.trim());

    }

    public boolean compareFilesByName(String searchedFileName, String fileName) {
        if (isEmpty(searchedFileName) || isEmpty(fileName)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        return searchedFileName.trim().toLowerCase().equals(fileName.trim().toLowerCase());
    }

    public String changeExtensionToLowerCase(String fileName) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Empty string!");
        }
        if (fileName.indexOf(".") < 1) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        return fileName.trim().replace(fileName.trim().substring(fileName.indexOf(".")), fileName.trim().substring(fileName.indexOf(".")).toLowerCase());
    }

    public String replaceStringPart(String fileName, String present, String target) {
        if (isEmpty(fileName) || isEmpty(target) || fileName.indexOf(".") < 1) {
            throw new IllegalArgumentException("Empty string!");
        }
        if (fileName.contains(present)) {
            fileName = fileName.trim().replace(present, target);
        }
        return fileName;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }
}
