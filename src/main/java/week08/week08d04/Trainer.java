package week08.week08d04;

public class Trainer {

    private CanMark canMark;

    public Trainer(CanMark canMark) {
        this.canMark = canMark;
    }

    public int giveMark() {
        return canMark.giveMark();
    }

    public static void main(String[] args) {
        Trainer goodMoodTrainer = new Trainer(new GoodMood());
        Trainer badMoodTrainer = new Trainer(new BadMood());

        System.out.println(goodMoodTrainer.giveMark());
        System.out.println(badMoodTrainer.giveMark());

    }

}
