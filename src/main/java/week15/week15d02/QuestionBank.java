package week15.week15d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class QuestionBank {

    private List<Question> questions = new ArrayList<>();

    public List<Question> getQuestions() {
        return new ArrayList<>(questions);
    }

    public void loadFileToList(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)){
            int lineCounter = 0;
            String line;
            String sentence = null;
            String answer;
            int point;
            Subject subject;
            while ((line = reader.readLine()) != null) {
                lineCounter++;
                if (isFirstLine(lineCounter)) {
                    sentence = line;
                } else {
                    String [] lineArray = line.split(" ");
                    answer = lineArray[0];
                    point = Integer.parseInt(lineArray[1]);
                    subject = Subject.valueOf(lineArray[2].trim().toUpperCase());
                    questions.add(new Question(sentence, answer, point, subject));
                }
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private boolean isFirstLine(int lineNumber) {
        return lineNumber % 2 == 1;
    }

    public List<String> selectSentencesBySubject(Subject subject) {
        return questions.stream().filter(a -> a.getSubject() == subject).map(Question::getSentence).collect(Collectors.toList());
    }

    public Question selectQuestionByRandom(int seed) {
        Random random = new Random(seed);
        int randomIndex = random.nextInt(questions.size());
        return questions.get(randomIndex);
    }

    public Map<Subject, List<Question>> makeMapBySubjects() {
        return questions.stream().collect(Collectors.groupingBy(Question::getSubject));
    }

    public Subject selectSubjectWithMostPoint() {
        Map<Subject, List<Question>> questionMap = makeMapBySubjects();
        Set<Map.Entry<Subject, List<Question>>> questionMapEntries = questionMap.entrySet();
        Optional<Map.Entry<Subject, List<Question>>> optionalResult = questionMapEntries.stream().max(Comparator.comparing(a -> a.getValue().stream().mapToInt(Question::getPoint).sum()));
        return optionalResult.map(Map.Entry::getKey).orElse(null);
    }
}

//    Adott egy vetélkedő kérdésbankja egy fájlban.
//    A fálban az egy kérdéshez tartozó adatok két sorban helyezkednek el.
//    Első sorban a kérdés, a második sorban a válasz a pontszám és a téma szóközzel elválasztava. Olvasd be a fájl tartalmát a memóriába, majd oldjátok meg a lenti feladatokat.

//        ```
//        Mikor volt a mohacsi vesz?
//        1526 1 tortenelem
//        Melyik evben bomlott fel a Nyugat-Romai Birodalom?
//        476 1 tortenelem
//        Melyik a legkisebb primszam?
//        2 1 matematika
//        Mennyi 64 kobgyoke?
//        4 2 matematika
//        Hany atloja van a szabalyos nyolcszognek?
//        24 2 matematika
//        Melyik evben kezdodott a Honfoglalas?
//        895 1 tortenelem
//        Mikor adtak ki az Aranybullat?
//        1222 1 tortenelem
//        Melyik evben adtak ki Angliaban a Magna Chartat?
//        1215 3 tortenelem
//        ```
//        1. Írj egy metódust, melynek paramétere a téma és add vissza, az összes kérdést abban a témában. (Csak a kérdéseket)
//        2. Írj egy metódust, ami random sorsol ki egy kérdést, és adja vissza annak összes adatát.
//        3. Készíts egy metódust ami rendszerezi a kérdéseket témakörönként. Visszatér egy datszerkezetben amelyben témánként megtalálható az összes kérdés.
//        4. Az előző feladat segítségével határozd meg, hogy melyik téma kérdései érik a legtöbb pontot (összpontszám)!
