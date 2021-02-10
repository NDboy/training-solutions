package week15.week15d02;

public class Question {

    private String sentence;
    private String answer;
    private int point;
    private Subject subject;

    public Question(String sentence, String answer, int point, Subject subject) {
        this.sentence = sentence;
        this.answer = answer;
        this.point = point;
        this.subject = subject;
    }

    public String getSentence() {
        return sentence;
    }

    public String getAnswer() {
        return answer;
    }

    public int getPoint() {
        return point;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return sentence + ", answer: " + answer + ", point: " + point + ", subject: " + subject;
    }
}
