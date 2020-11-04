package arrayofarrays;

public class ArrayOfArraysMain {

    public void printArrayOfArrays(int[][] a) {
        for (int i[] : a) {
            for (int j : i) {
                System.out.print(j);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public int [] [] multiplicationTable(int size) {
        int [] [] multiplicator = new int [size] [size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                multiplicator [i] [j] = (i + 1) * (j + 1);
            }
        }
        return multiplicator;
    }

    public int [][] triangularMatrix(int size) {
        int [][] triangular = new int[size][];
        for (int i = 0; i < size; i++) {
            triangular [i] = new int[i+1];
            for (int j = 0; j <= i; j++) {
                triangular [i][j] = i;
            }
        }
        return triangular;
    }

    public int [][] getValues() {
        int[][] months = new int [12][];
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i =0; i < 12; i++) {
            months[i] = new int[days[i]];
            for (int j = 0; j < days[i]; j++) {
                months [i] [j] = j + 1;
            }
        }
        return months;

    }



    public static void main(String[] args) {
        ArrayOfArraysMain arrayOfArraysMain = new ArrayOfArraysMain();

        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.triangularMatrix(4));
        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.multiplicationTable(4));
        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.getValues());


    }
}
