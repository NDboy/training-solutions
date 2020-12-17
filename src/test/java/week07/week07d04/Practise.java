package week07.week07d04;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Practise {

//    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
//        int aPoints = 0;
//        int bPoints = 0;
//        for(int i = 0; i < a.size(); i++) {
//            if (a.get(i) > b.get(i)) {
//                aPoints++;
//            } else if (a.get(i) < b.get(i)) {
//                bPoints++;
//            }
//        }
//        List<Integer> result = Arrays.asList(aPoints, bPoints);
//        return result;
//    }

//    static long aVeryBigSum(long[] ar) {
//        long sum = 0;
//        for (long number: ar) {
//            sum += number;
//        }
//        return sum;
//
//    }

//    public static int diagonalDifference(List<List<Integer>> arr) {
//        int sum1 = 0;
//        int sum2 = 0;
//        for (int i = 0; i < arr.size(); i++) {
//            sum1 += arr.get(i).get(i);
//        }
//        for (int i = arr.size(); i >= 0; i--) {
//            sum2 += arr.get(2 - i).get(2 - i);
//        }
//        return Math.abs(sum1 - sum2);
//    }

//    static void plusMinus(int[] arr) {
//        int minusCounter = 0;
//        int zeroCounter = 0;
//        int plusCounter = 0;
//        for (int i : arr) {
//            if (i < 0) {
//                minusCounter++;
//            } else if (i == 0) {
//                zeroCounter++;
//            } else {
//                plusCounter++;
//            }
//        }
//        System.out.println(String.format("%8.6f", ((double)plusCounter)/ arr.length));
//        System.out.println(String.format("%8.6f", ((double)minusCounter)/ arr.length));
//        System.out.println(String.format("%8.6f", ((double)zeroCounter)/ arr.length));
//    }
//    static void staircase(int n) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n - 1 - i; j++) {
//                sb.append(" ");
//            }
//            for (int j = 0; j <= i; j++) {
//                sb.append("#");
//            }
//            System.out.println(sb.toString());
//            sb = new StringBuilder();
//        }
//    }

//    static void miniMaxSum(int[] arr) {
//        long min = arr[0];
//        long max = arr[0];
//        long minSum = 0;
//        long maxSum = 0;
//        int minInd = 0;
//        int maxInd = 0;
//        for (int i = 1; i < arr.length ; i++) {
//            if (min > arr[i]) {
//                min = arr[i];
//                minInd = i;
//            }
//            if (max < arr[i]) {
//                max = arr[i];
//                maxInd = i;
//            }
//        }
//        for (int i = 0; i < arr.length ; i++) {
//            if (minInd != i) {
//                maxSum += arr[i];
//            }
//            if (maxInd != i) {
//                minSum += arr[i];
//            }
//        }
//        System.out.println(minSum + "  " + maxSum);
//    }


//    public static int birthdayCakeCandles(List<Integer> candles) {
//        int minValue = candles.get(0);
//        int counter = 0;
//        for (int candle: candles) {
//            if (candle > minValue) {
//                counter = 1;
//                minValue = candle;
//            } else if (candle == minValue) {
//                counter++;
//            }
//        }
//        return counter;
//
//    }

//    static String timeConversion(String s) {
//        StringBuilder sb = new StringBuilder();
//        if ("PM".equals(s.substring(8)) && Integer.parseInt(s.substring(0, 2)) >= 1 && Integer.parseInt(s.substring(0, 2)) < 12) {
//            sb.append(Integer.parseInt(s.substring(0, 2)) + 12);
//            sb.append(s.substring(2, 8));
//        } else if ("AM".equals(s.substring(8)) && Integer.parseInt(s.substring(0, 2)) == 12) {
//            sb.append(/*Integer.parseInt(s.substring(0, 2)) - 12*/"00");
//            sb.append(s.substring(2, 8));
//        } else {
//            sb.append(s.substring(0, 8));
//        }
//        return sb.toString();
//    }
//
//    static int[] xorMatrix(int m, int[] first_row) {
//        int [] row = new int [first_row.length];
//        for (int j = 0; j < m - 1; j++) {
//            for (int i = 0; i < first_row.length - 1; i++) {
//                row[i] = first_row[i] ^ first_row[i + 1];
//            }
//            row[first_row.length - 1] = first_row[0] ^ first_row[first_row.length - 1];
//            first_row = row;
//        }
//        return row;
//    }


//    public static List<Integer> gradingStudents(List<Integer> grades) {
//        for (int i = 0; i < grades.size(); i++) {
//            if (grades.get(i) > 37) {
//                if (grades.get(i) % 5 >= 3) {
//                    grades.set(i, (grades.get(i) / 5 * 5 + 5));
//                }
//            }
//        }
//        return grades;
//    }



//    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
//        int appleCounter = 0;
//        int orangeCounter = 0;
//        for (int appleDistance: apples) {
//            if (a + appleDistance >= s && a +appleDistance <= t) {
//                appleCounter++;
//            }
//        }
//        for (int orangeDistance: oranges) {
//            if (b + orangeDistance >= s && b + orangeDistance <= t) {
//                orangeCounter++;
//            }
//        }
//        System.out.println(appleCounter);
//        System.out.println(orangeCounter);
//    }


//    static String kangaroo(int x1, int v1, int x2, int v2) {
//        if (v1 == v2 && x1 != x2) {
//            return "NO";
//        } else if ((x1 - x2)%(v1 - v2) == 0 && (((x1 >= x2 && v1 <= v2)) || (x1 <= x2 && v1 >= v2))) {
//            return "YES";
//        } else {
//            return "NO";
//        }
//
//    }

//    static int[] breakingRecords(int[] scores) {
//        int highestScore = scores[0];
//        int lowestScore = scores[0];
//        int counterHigh = 0;
//        int counterLow = 0;
//        for (int score : scores) {
//            if (score > highestScore) {
//                highestScore = score;
//                counterHigh++;
//            }
//            if (score < lowestScore) {
//                lowestScore = score;
//                counterLow++;
//            }
//        }
//        int[] result = new int[2];
//        result[0] = counterHigh;
//        result[1] = counterLow;
//        return result;
//    }

//    static int birthday(List<Integer> s, int d, int m) {
//        int sum = 0;
//        int counter = 0;
//        for (int i = 0; i <= s.size() - m; i++) {
//            for (int j: s.subList(i, i + m)) {
//                sum += j;
//            }
//            if (sum == d) {
//                counter++;
//            }
//            sum = 0;
//        }
//        return counter;
//    }

//    static int divisibleSumPairs(int n, int k, int[] ar) {
//        int element = ar[0];
//        int counter = 0;
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if ((element + ar[j]) % k == 0) {
//                    counter++;
//                }
//            }
//            element = ar[i + 1];
//        }
//        return counter;
//    }


//    static int migratoryBirds(List<Integer> arr) {
//        int counter = 0;
//        int counterMax = 1;
//        int itemPuffer = arr.get(0);
//        List<Integer> done = new ArrayList<>();
//        for (int i = 0; i < arr.size(); i++){
//            if (!done.contains(arr.get(i))) {
//                for (int j = 0; j < arr.size(); j++) {
//                    if (arr.get(i) == arr.get(j)) {
//                        counter++;
//                    }
//                }
//                if (counter > counterMax) {
//                    itemPuffer = arr.get(i);
//                    counterMax = counter;
//                } else if (counter == counterMax) {
//                    itemPuffer = Math.min(itemPuffer, arr.get(i));
//                }
//                done.add(arr.get(i));
//                counter = 0;
//            }
//        }
//        return itemPuffer;
//    }


//    static String dayOfProgrammer(int year) {
//        String result = null;
//        boolean gregorianLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
//        boolean julianLeapYear = year % 4 == 0;
//
//        if (year <= 1917) {
//            if (!julianLeapYear) {
//                result = "13.09." + year;
//            } else {
//                result = "12.09." + year;
//            }
//        } else if (year == 1918) {
//            result = "26.09." + year;
//        } else if (year >= 1919) {
//            if (!gregorianLeapYear) {
//                result = "13.09." + year;
//            } else {
//                result = "12.09." + year;
//            }
//        }
//        return result;
//    }

//    static void bonAppetit(List<Integer> bill, int k, int b) {
//        int sum = 0;
//        for (int i = 0; i < bill.size(); i++) {
//            if (i != k) {
//                sum += bill.get(i);
//            }
//        }
//        if (sum / 2.0 == b) {
//            System.out.println("Bon Appetit");
//        } else {
//            System.out.println(b - sum / 2.0);
//        }
//    }

//    static int sockMerchant(int n, int[] ar) {
//        int counter = 0;
//        int counterMax = 0;
//        List<Integer> done = new ArrayList<>();
//        for (int i = 0; i < ar.length; i++){
//            if (!done.contains(ar[i])) {
//                for (int j = 0; j < ar.length; j++) {
//                    if (ar[i] == ar[j]) {
//                        counter++;
//                    }
//                }
//                if (counter > 1) {
//                    counterMax += counter / 2;
//                }
//                done.add(ar[i]);
//                counter = 0;
//            }
//        }
//        return counterMax;
//    }

//    static int pageCount(int n, int p) {
//
//        return Math.min(p/2, (n - p)/2);
//    }


//    public static int countingValleys(int steps, String path) {
//        int counter = 0;
//        int level = 0;
//        for (int i = 1; i < steps; i++) {
//            if (path.charAt(i - 1) == 'U') {
//                level++;
//            } else {
//                level--;
//            }
//            if (level < 0 && 0 == level + (path.charAt(i) == 'U' ? 1 : -1)) {
//                counter++;
//            }
//        }
//        return counter;
//    }

//    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
//        int difference = 0;
//        int puffer = b;
//        boolean possible = false;
//        for (int keyboard: keyboards) {
//            for (int drive : drives) {
//                if (b >= (keyboard + drive)) {
//                    difference = b - (keyboard + drive);
//                    if (difference <= puffer) {
//                        puffer = difference;
//                        possible = true;
//                    }
//                }
//            }
//        }
//        return possible ? b - puffer : -1;
//
//
//    }

//    static String catAndMouse(int x, int y, int z) {
//        String str = null;
//        if (Math.abs(x - z) == Math.abs(y - z)) {
//            str = "Mouse C";
//        } else if (Math.abs(x - z) > Math.abs(y - z)) {
//            str = "Cat B";
//        } else if (Math.abs(x - z) < Math.abs(y - z)) {
//            str = "Cat A";
//        }
//        return str;
//    }

//    static int formingMagicSquare(int[][] s) {
//        int difference = 45;
//        int sum = 0;
//        List<Integer> original = new ArrayList<>();
//        for (int i = 0; i < s.length; i++) {
//            for (int j = 0; j < s.length; j++) {
//                original.add(s[i][j]);
//            }
//        }
//        int[][] generated = {{4, 9, 2, 3, 5, 7, 8, 1, 6}, {6, 1, 8, 7, 5, 3, 2, 9, 4}, {2, 9, 4, 7, 5, 3, 6, 1, 8}, {8, 1, 6, 3, 5, 7, 4, 9, 2}, {8, 3, 4, 1, 5, 9, 6, 7, 2}, {4, 3, 8, 9, 5, 1, 2, 7, 6}, {6, 7, 2, 1, 5, 9, 8, 3, 4}, {2, 7, 6, 9, 5, 1, 4, 3, 8}};
//        for (int i = 0; i < generated.length; i++) {
//            for (int j = 0; j < 9; j++) {
//                sum += Math.abs(generated[i][j] - original.get(j));
//            }
//            if (sum < difference) {
//                difference = sum;
//            }
//            sum = 0;
//        }
//        return difference;
//    }

//    public static int pickingNumbers(List<Integer> a) {
//
//        int counter = 0;
//        int puffer = 1;
//        for (Integer actOuter: a) {
//            for (Integer actInner: a) {
//                if (actOuter - actInner <= 1 && actOuter - actInner >= 0) {
//                    counter++;
//                }
//            }
//            if (counter > puffer) {
//                puffer = counter;
//            }
//            counter = 0;
//        }
//        return puffer;
//    }

//    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
//        List<Integer> rankings = new ArrayList<>();
//        rankings.add(1);
//        List<Integer> result = new ArrayList<>();
//        int puffer = ranked.get(0);
//        int counter = 1;
//        boolean isGreater = false;
//        for (int i = 1; i < ranked.size(); i++) {
//            if (ranked.get(i) == puffer) {
//                rankings.add(counter);
//            } else if (ranked.get(i) < puffer){
//                counter++;
//                rankings.add(counter);
//            }
//            puffer = ranked.get(i);
//        }
//        for (int i = 0; i < player.size(); i++) {
//            for (int j = 0; j < ranked.size(); j++) {
//                if (player.get(i) > ranked.get(j) && !isGreater) {
//                    result.add(rankings.get(j));
//                    isGreater = true;
//                } else if (player.get(i) == ranked.get(j) && !isGreater) {
//                    result.add(rankings.get(j));
//                    isGreater = true;
//                }
//            }
//            if (!isGreater) {
//                result.add(rankings.get(rankings.size() - 1) + 1);
//            }
//            isGreater = false;
//        }
//        return result;
//    }

//    static int hurdleRace(int k, int[] height) {
//        int diff = 0;
//        for (int i = 0; i < height.length; i++) {
//            if (diff < height[i] - k) {
//                diff = height[i] - k;
//            }
//        }
//        return diff;
//    }


//    static int designerPdfViewer(int[] h, String word) {
//        char [] abc = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
//        int puffer = 0;
//        for (int i = 0; i < word.length(); i++) {
//            for (int j = 0; j < h.length; j++) {
//                if(word.charAt(i) == abc[j]) {
//                    if(puffer <= h[j]) {
//                        puffer = h[j];
//                    }
//                }
//            }
//        }
//        return puffer * word.length();
//    }

//    static int utopianTree(int n) {
//        int base = 1;
//        for (int i = 1; i <= n; i++) {
//            if (i % 2 == 0) {
//                base++;
//            } else {
//                base *= 2;
//            }
//        }
//        return base;
//    }

//    static String angryProfessor(int k, int[] a) {
//        int counter = 0;
//        for (int time: a) {
//            if (time <= 0) {
//                counter++;
//            }
//        }
//        return counter >= k ? "YES" : "NO";
//    }


//    static int beautifulDays(int i, int j, int k) {
//        StringBuilder sb = new StringBuilder();
//        int counter = 0;
//        for (int n = i; n <= j; n++) {
//            if (Math.abs(Integer.parseInt(sb.append(n).reverse().toString()) - n) % k == 0) {
//                sb.delete(0, 2);
//                counter++;
//            }
//        }
//        return counter;
//    }


//    static int viralAdvertising(int n) {
//        int counter = 0;
//        int puffer = 5;
//        for (int i = 0; i < n; i++) {
//            counter += puffer / 2;
//            puffer = 5 / 2 * 3;
//        }
//        return counter;
//
//    }


//    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
//        int [] result = new int[queries.length];
//        for(int j = 0; j < queries.length; j++) {
//            result[j] = a[j - k < 0 ? a.length + j - k : j - k];
//        }
//        return result;
//    }



//    static int[] permutationEquation(int[] p) {
//        int [] result = new int[p.length];
//        int puffer = 0;
//        for (int i = 0; i < p.length; i++) {
//            for (int j = 0; j < p.length; j++) {
//                if (i + 1 == p[j]) {
//                    puffer = j + 1;
//                }
//                result[p[i]-1] = puffer;
//            }
//        }
//        return result;
//    }


//    static int jumpingOnClouds(int[] c, int k) {
//        int power = 99 - (2 * c[0]);
//        for (int i = 0; i < c.length - k; i+=k) {
//            power -= 1 + (2 * c[i + k]);
//        }
//        return power;
//    }


//    static int findDigits(int n) {
//        int counter = 0;
//        String str = Integer.toString(n);
//        for (int i = 0; i < str.length(); i++) {
//            if (Integer.parseInt(str.substring(i, i + 1)) != 0 && n % Integer.parseInt(str.substring(i, i + 1)) == 0){
//                counter++;
//            }
//        }
//        return counter;
//
//    }


    static void extraLongFactorials(int n) {
        BigDecimal big = new BigDecimal(n);
        for (int i = 1; i < n; i++) {
            big = new BigDecimal(i).multiply(big);
        }
        System.out.println(big);
    }




    public static void main(String[] args) {


//        System.out.println(Practise.countingValleys(8, "UDDDUDUU"));

//        int [] res = {1, 7, 14, 8, 2, 1, 7, 14, 8, 2};
//        res[0] = 2;
        int [] res2 = {0,1,1,0,1,0,1,1,0,1,1,0,0,0,0,0,1,1,1,1,1,0,1,0};
//        int i = 1 ^ 2;
//        System.out.println(Practise.xorMatrix(2, res).length);
//        System.out.println(Practise.xorMatrix(2, res)[0]);

//          System.out.println(Practise.migratoryBirds(Arrays.asList(33,37,38,41,43,44,45,55,57,11,58,87,38,11,14,37,15,-5,-9,45,88,57,88,33,33,11,11,33,41,11,88)));
//        System.out.println(Practise.dayOfProgrammer(1918));
//        List<Integer> ranked = new ArrayList<>();
//        List<Integer> player = new ArrayList<>();
//        Scanner scanner = new Scanner("997 981 957 933 930 927 926 920 916 896 887 874 863 863 858 847 815 809 803 794 789 785 783 778 764 755 751 740 737 730 691 677 652 650 587 585 583 568 546 541 540 538 531 527 506 493 457 435 430 427 422 422 414 404 400 394 387 384 374 371 369 369 368 365 363 337 336 328 325 316 314 306 282 277 230 227 212 199 179 173 171 168 136 125 124 95 92 88 85 70 68 61 60 59 44 43 28 23 13 12");
//        while (scanner.hasNextInt()) {
//            ranked.add(scanner.nextInt());
//        }
//        Scanner scanner1 = new Scanner("12 20 30 32 35 37 63 72 83 85 96 98 98 118 122 125 129 132 140 144 150 164 184 191 194 198 200 220 228 229 229 236 238 246 259 271 276 281 283 287 300 302 306 307 312 318 321 325 341 341 341 344 349 351 354 356 366 369 370 379 380 380 396 405 408 417 423 429 433 435 438 441 442 444 445 445 452 453 465 466 467 468 469 471 475 482 489 491 492 493 498 500 501 504 506 508 523 529 530 539 543 551 552 556 568 569 571 587 591 601 602 606 607 612 614 619 620 623 625 625 627 638 645 653 661 662 669 670 676 684 689 690 709 709 710 716 724 726 730 731 733 737 744 744 747 757 764 765 765 772 773 774 777 787 794 796 797 802 805 811 814 819 819 829 830 841 842 847 857 857 859 860 866 872 879 882 895 900 900 903 905 915 918 918 922 925 927 928 929 931 934 937 955 960 966 974 982 988 996 996");
//        while (scanner1.hasNextInt()) {
//            player.add(scanner1.nextInt());
//        }

//        System.out.println(stringListsUnion(Arrays.asList("alma", "körte", "banán", "szőlő", "alma"), Arrays.asList("kókusz", "körte", "narancs", "dinnye", "alma")));
        extraLongFactorials(30);



    }
}
