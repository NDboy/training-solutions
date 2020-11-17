package stringmethods;

public class FileNameManipulator {
    private String fileName;


    public FileNameManipulator(String fileName) {
        if (fileName == null || fileName.trim().equals("")) {
            throw new IllegalArgumentException("Filename must not be empty.");
        }
        this.fileName = fileName;
    }

    public char findLastCharacter(String str) {
        if (str.isBlank()) {
            throw new IllegalArgumentException("Empty string!");
        }
        return str.trim().charAt(str.length()-1);
    }

    public String findFileExtension(String fileName) {
        if (fileName.isBlank()) {
            throw new IllegalArgumentException("Empty string!");
        }
        return fileName.trim().substring(fileName.indexOf("."));
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        if (ext.isBlank() || fileName.isBlank()) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        return fileName.trim().endsWith("." + ext.trim());
//        return fileName.indexOf("." + ext) >= 0;
    }

    public boolean compareFileByName(String searchedFileName, String fileName) {
        if (searchedFileName.isBlank() || fileName.isBlank()) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        return searchedFileName.trim().equals(fileName.trim());
    }

    public void changeExtensionToLowerCase(String fileName) {
        if (fileName.isBlank()) {
            throw new IllegalArgumentException("Empty String!");
        }
        fileName = fileName.trim().replace(fileName.trim().substring(fileName.indexOf(".")), fileName.trim().substring(fileName.indexOf(".")).toLowerCase());
    }

    public void replaceStringPart(String fileName, String present, String target) {
        fileName = fileName.trim().replace(present, target);
    }



}
