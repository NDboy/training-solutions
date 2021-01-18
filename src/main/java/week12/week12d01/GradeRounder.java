package week12.week12d01;

public class GradeRounder {

    public int[] roundGrades(int[] grades) {
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > 40 && grades[i] % 5 >= 3) {
                grades[i] = grades[i] / 5 * 5 + 5;
            }
        }
        return grades;
    }

}

