package methodvarargs.examstats;

public class ExamStats {
    private int maxPoints;

    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results) {
        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }
        int counter = 0;
        for (int result: results) {
            if ((double)result/maxPoints > limitInPercent/100.0) {
                counter++;
            }
        }
        return counter;
    }

    public boolean hasAnyFailed(int limitInPercent, int... results) {
        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }
        boolean hasFailed = false;
        for (int result: results) {
            if ((double)result/maxPoints < limitInPercent/100.0) {
                hasFailed = true;
            }
        }
        return hasFailed;
    }


}
