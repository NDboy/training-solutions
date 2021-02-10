package week15.week15d02;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class QuestionBankTest {


    @Test
    void testLoadFileToList() {
        QuestionBank questionBank = new QuestionBank();
        Path path = Path.of("kerdesek.txt");
        questionBank.loadFileToList(path);
        assertEquals(57, questionBank.getQuestions().size());
        assertEquals("Melyik evben bomlott fel a Nyugat-Romai Birodalom?", questionBank.getQuestions().get(1).getSentence());
        assertEquals(Subject.TORTENELEM, questionBank.getQuestions().get(1).getSubject());

    }

    @Test
    void testSelectSentencesBySubject() {
        QuestionBank questionBank = new QuestionBank();
        Path path = Path.of("kerdesek.txt");
        questionBank.loadFileToList(path);
        assertEquals(21, questionBank.selectSentencesBySubject(Subject.MATEMATIKA).size());
        assertEquals("Mennyi 1000 tizes alapu logaritmusa?", questionBank.selectSentencesBySubject(Subject.MATEMATIKA).get(1));
    }

    @Test
    void testSelectQuestionByRandom() {
        QuestionBank questionBank = new QuestionBank();
        Path path = Path.of("kerdesek.txt");
        questionBank.loadFileToList(path);
        assertEquals("Hany lakosa volt Magyarorszag legkisebb telepulesenek, Iborfianak, 2012 januar 1-en?, answer: 9, point: 3, subject: FOLDRAJZ", questionBank.selectQuestionByRandom(5).toString());
        assertEquals("Melyik evben volt a Budai Nagy Antal-fele parasztfelkeles?, answer: 1437, point: 2, subject: TORTENELEM", questionBank.selectQuestionByRandom(10).toString());
    }

    @Test
    void testMakeMapBySubjects() {
        QuestionBank questionBank = new QuestionBank();
        Path path = Path.of("kerdesek.txt");
        questionBank.loadFileToList(path);
        Map<Subject, List<Question>> questionMap = questionBank.makeMapBySubjects();
        Set<Subject> subjectSet = Set.of(Subject.MAGYAR, Subject.MATEMATIKA, Subject.FOLDRAJZ, Subject.TORTENELEM,Subject.KEMIA);
        assertEquals(subjectSet, questionMap.keySet());
        assertEquals(21, questionMap.get(Subject.MATEMATIKA).size());
    }

    @Test
    void testSelectSubjectWithMostPoint() {
        QuestionBank questionBank = new QuestionBank();
        Path path = Path.of("kerdesek.txt");
        questionBank.loadFileToList(path);
        assertEquals(Subject.MATEMATIKA, questionBank.selectSubjectWithMostPoint());
    }
}