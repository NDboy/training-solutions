package week07.week07d04;

import org.junit.platform.commons.util.ToStringBuilder;

import javax.swing.tree.TreePath;
import java.awt.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

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

//    static void extraLongFactorials(int n) {
//        BigDecimal big = new BigDecimal(n);
//        for (int i = 1; i < n; i++) {
//            big = new BigDecimal(i).multiply(big);
//        }
//        System.out.println(big);
//    }

//    static int squares(int a, int b) {
//        int counter = 0;
//        for (int i = (int)Math.sqrt((double)a); i < b; i++) {
//            if (Math.pow((double)i, 2.0) >= a && Math.pow((double)i, 2.0) <= b) {
//                counter++;
//            }
//        }
//
//        return counter;
//    }

//    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
//        LocalDate actual = LocalDate.of(y1,m1,d1);
//        LocalDate dueTo = LocalDate.of(y2,m2,d2);
//        int fine = 0;
//        if (actual.isBefore(dueTo) || actual.isEqual(dueTo)) {
//            fine = 0;
//        } else {
//            if (actual.getYear() == dueTo.getYear() && actual.getMonth() == dueTo.getMonth()) {
//                fine = (int)ChronoUnit.DAYS.between(dueTo, actual) * 15;;
//            } else if (actual.getYear() == dueTo.getYear() && actual.getMonth() != dueTo.getMonth()) {
//                fine =  (m1-m2) * 500;;
//            } else if (actual.getYear() != dueTo.getYear()) {
//                fine = 10000;
//            }
//        }
//        return fine;
//    }

//    static int[] cutTheSticks(int[] arr) {
//        List<Integer> sticks = new ArrayList<>(arr.length);
//        for (int ar: arr) {
//            sticks.add(ar);
//        }
//        List<Integer> results = new ArrayList<>();
//        List<Integer> puffer = new ArrayList<>(arr.length);
//
//        int actual = 0;
//        while (sticks.size() > 0) {
//            int shortest = sticks.get(0);
//            results.add(sticks.size());
//            for (Integer stick: sticks) {
//                shortest = Math.min(stick, shortest);
//            }
//            for (Integer stick: sticks) {
//                actual = stick - shortest;
//                if (actual > 0) {
//                    puffer.add(actual);
//                }
//            }
//            sticks.clear();
//            sticks.addAll(puffer);
//            puffer.clear();
//        }
//        int[] result = new int[results.size()];
//        for (int i = 0; i < results.size(); i++) {
//            result[i] = results.get(i);
//        }
//        return result;
//    }

//    static long repeatedString(String s, long n) {
//        long counter = 0;
//        if (s.length() < n) {
//            for (int i = 0; i < s.length(); i++) {
//                if (s.charAt(i) == 'a') {
//                    counter++;
//                }
//            }
//            counter *= n / s.length();
//        }
//        for (int i = 0; i < n % s.length(); i++) {
//            if (s.charAt(i) == 'a') {
//                counter++;
//            }
//        }
//        return counter;
//    }

//    static int jumpingOnClouds(int[] c) {
//        int jumps = 0;
//        for (int i = 0; i < c.length - 1; i+=2) {
//            jumps++;
//            if (i != 0 && c[i] == 1) {
//                i--;
//            }
//        }
//        return jumps;
//    }

//    static int equalizeArray(int[] arr) {
//        int buffer = 1;
//        int counter = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int ar: arr) {
//                if (arr[i] == ar) {
//                    counter++;
//                }
//            }
//            if (counter > buffer) {
//                buffer = counter;
//            }
//            counter = 0;
//        }
//        return arr.length - buffer;
//    }

//    public static long taumBday(int b, int w, int bc, int wc, int z) {
//        long result = 0;
//        if (Math.abs(bc - wc) <= z) {
//            result = b * bc + w * wc;
//        } else if ((bc - wc) > z) {
//            result = w * wc + (wc + z) * b;
//        } else if ((wc - bc) > z) {
//            result = b * bc + (bc + z) * w;
//        }
//        return result;
//    }

//    static int[] acmTeam(String[] topic) {
//        int[] result = new int[2];
//        int counter = 0;
//        int buffer = 0;
//        int max = 0;
//        for (int i = 0; i < topic.length; i++) {
//            for (int j = i + 1; j < topic.length; j++) {
//                for (int k = 0; k < topic[i].length(); k++) {
//                    if (topic[i].charAt(k) == '1' || topic[j].charAt(k) == '1') {
//                        counter++;
//                    }
//                }
//                if (counter > buffer) {
//                    buffer = counter;
//                    max = 1;
//                } else if (counter == buffer) {
//                    max++;
//                }
//                counter = 0;
//            }
//        }
//        result [0] = buffer;
//        result [1] = max;
//        return result;
//    }

//    static boolean isKaprekar (int n) {
//        boolean isTrue = false;
//        StringBuilder sbl = new StringBuilder();
//        StringBuilder sbr = new StringBuilder();
//        String nStr = Integer.toString(n);
//        String str = Long.toString((long)Math.pow(n, 2.0));
//
//            sbl.append(str.substring(0, str.length() - nStr.length()));
//            for (int i = str.length() - nStr.length(); i < str.length(); i++) {
//                if (str.charAt(i) != '0') {
//                    sbr.append(str.charAt(i));
//                } else if (str.charAt(i) == '0' && sbr.length() > 0) {
//                    sbr.append(str.charAt(i));
//                }
//            }
//            if (sbl.length() == 0) {
//                sbl.append("0");
//            }
//            if (sbr.length() > 0 && n == Integer.parseInt(sbl.toString()) + Integer.parseInt(sbr.toString())) {
//                isTrue = true;
//            }
//        return isTrue;
//    }
//
//
//    static void kaprekarNumbers(int p, int q) {
//        StringBuilder result = new StringBuilder();
//        for (int i = p; i <= q; i++) {
//            if (isKaprekar(i)) {
//                result.append(i + " ");
//            }
//        }
//        if (result.length() == 0) {
//            System.out.println("INVALID RANGE");
//        } else {
//            System.out.println(result.toString().trim());
//        }
//    }

//    static int beautifulTriplets(int d, int[] arr) {
//        List<Integer> list = new ArrayList<>();
//        int counter = 0;
//        int plusDCounter = 0;
//        int plus2DCounter = 0;
//        for (int i = 0; i < arr.length; i++) {
//            list.add(arr[i]);
//        }
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = i + 1; j < list.size(); j++) {
//                if (list.get(j) == list.get(i) + d) {
//                    plusDCounter++;
//                } else if (list.get(j) == list.get(i) + 2 * d) {
//                    plus2DCounter++;
//                }
//            }
//            if (plusDCounter > 0 && plus2DCounter > 0) {
//                counter += plusDCounter * plus2DCounter;
//            }
//            plus2DCounter = 0;
//            plusDCounter = 0;
//        }
//        return counter;
//    }

//    static int minimumDistances(int[] a) {
//        int buffer = -1;
//        int difference = 0;
//        for (int i = 0; i < a.length; i++) {
//            for (int j = i + 1; j < a.length; j++) {
//                if (a[i] == a[j]) {
//                    difference = j - i;
//                    if (buffer == -1 || difference < buffer) {
//                        buffer = difference;
//                    }
//                }
//            }
//        }
//        return buffer;
//    }

//    static int howManyGames(int p, int d, int m, int s) {
//        int counter = 0;
//        for (int i = p; s >= 0; i-=d) {
//            s -= Math.max(i , m);
//            counter++;
//        }
//        return counter;
//    }

//    static int chocolateFeast(int n, int c, int m) {
//        int result = 0;
//        int wrappers = 0;
//        while (n >= c || wrappers >= m) {
//            if (n >= c) {
//                result++;
//                n -= c;
//                wrappers ++;
//            } else {
//                result++;
//                wrappers -= m;
//                wrappers++;
//            }
//        }
//        return result;
//
//    }

//    static int[] serviceLane(int n, int[][] cases, int[] width) {
//        int [] result = new int[cases.length];
//        int min = 3;
//        for (int i = 0; i < cases.length; i++) {
//            for (int j = cases[i][0]; j <= cases[i][1] ; j++) {
//                min = Math.min(min, width[j]);
//            }
//            result[i] = min;
//            min = 3;
//        }
//        return result;
//    }

//    static int workbook(int n, int k, int[] arr) {
//        int counter = 0;
//        int result = 0;
//        int page = 1;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 1; j <= arr[i]; j++) {
//                counter++;
//                if (counter > k) {
//                    page++;
//                    counter = 1;
//                }
//                if (page == j) {
//                    result++;
//                }
//            }
//            counter = 0;
//            page++;
//        }
//        return result;
//
//    }

//    static String fairRations(int[] B) {
//        List<Integer> list = new ArrayList<>();
//        int counter = 0;
//        for (int b: B) {
//            list.add(b);
//        }
//        for (int i = 0; i < list.size() - 1; i++) {
//            if (list.get(i) % 2 != 0) {
//                list.set(i, list.get(i) + 1);
//                list.set(i + 1, list.get(i + 1) + 1);
//                counter += 2;
//            }
//        }
//        if (list.get(list.size() - 1) % 2 != 0) {
//            System.out.println("NO");
//            return "NO";
//        } else {
//            return Integer.toString(counter);
//        }
////    }

//    static String[] cavityMap(String[] grid) {
//        String [] result = grid.clone();
//        for (int i = 1; i < grid.length - 1; i++) {
//            for (int j = 1; j < grid[i].length() - 1; j++) {
//                if (    Integer.parseInt(grid[i].substring(j,j+1)) > Integer.parseInt(grid[i - 1].substring(j,j+1)) && Integer.parseInt(grid[i].substring(j,j+1)) > Integer.parseInt(grid[i + 1].substring(j,j+1)) &&
//                        Integer.parseInt(grid[i].substring(j,j+1)) > Integer.parseInt(grid[i].substring(j - 1,j)) && Integer.parseInt(grid[i].substring(j,j+1)) > Integer.parseInt(grid[i].substring(j + 1,j + 2))) {
//                    char [] line = result[i].toCharArray();
//                    line[j] = 'X';
//                    result[i] = new String(line);
//                }
//            }
//        }
//        return result;
//    }

//    static int[] stones(int n, int a, int b) {
//        if (a == b) {
//            int [] result = new int[1];
//            result[0] = (n-1) * a;
//            return result;
//        } else {
//            int[] result = new int[n];
//            for (int i = 1; i <= n; i++) {
//                result[i - 1] = Math.min(a, b) * (n - i) + Math.max(a, b) * (i - 1);
//            }
//            return result;
//        }
//    }

//    static int flatlandSpaceStations(int n, int[] c) {
//        int result = 0;
//        int min;
//        for (int i = 0; i < n; i++) {
//            min = n;
//            for (int j = 0; j < c.length; j++) {
//                min = Math.min(min, Math.abs(c[j] - i));
//            }
//            result = Math.max(result, min);
//        }
//        return result;
//    }

//    static String happyLadybugs(String b) {
//        String result = "NO";
//        boolean happy = true;
//        int counter = 0;
//        for (int i = 0; i < b.length(); i++) {
//            for (int j = 0; j < b.length(); j++) {
//                if (b.charAt(i) == b.charAt(j) && b.charAt(i) != '_') {
//                    counter++;
//                }
//            }
//            if (counter < 2 && b.charAt(i) != '_') {
//                happy = false;
//            }
//            counter = 0;
//        }
//        if (b.contains("_") && happy) {
//            result = "YES";
//        }
//        if (!b.contains("_") && b.length() > 1 && b.charAt(0) == b.charAt(1) && b.charAt(b.length()-1) == b.charAt(b.length()-2)) {
//            happy = true;
//            for (int i = 1; i < b.length() - 1; i++) {
//                if (b.charAt(i) != b.charAt(i - 1) && b.charAt(i) != b.charAt(i + 1)) {
//                    happy = false;
//                }
//            }
//            if (happy) {
//                result = "YES";
//            }
//        }
//        return result;
//    }

//    static long strangeCounter(long t) {
//        long counter = 1;
//        long result = 3;
//        for (int i = 1; i < t; i++) {
//            result--;
//            if (result < 1) {
//                counter *= 2;
//                result = 3 * counter;
//            }
//        }
//        return result;
//    }

//    static void insertionSort1(int n, int[] arr) {
//        int [] buffer = arr.clone();
//        int last = arr[n - 1];
//        boolean isOk = true;
//        StringBuilder sb = new StringBuilder();
//        for (int i = n - 1; i >= 0 && isOk; i--) {
//            if (i > 0) {
//                if (arr[i - 1] > last) {
//                    buffer[i] = arr[i - 1];
//                } else if (arr[i - 1] < last) {
//                    buffer[i] = last;
//                    isOk = false;
//                }
//            } else {
//                buffer[i] = last;
//            }
//            for (int item: buffer) {
//                sb.append(item + " ");
//            }
//            System.out.println(sb.toString().trim());
//            sb = new StringBuilder();
//        }
//    }

//    static void insertionSort2(int n, int[] arr) {
//        int buffer = 0;
//        List<Integer> list = new ArrayList<>(n);
//        for (int i: arr) {
//            list.add(i);
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (list.get(i) < list.get(j)) {
//                    buffer = list.get(i);
//                    list.remove(i);
//                    list.add(j, buffer);
//                }
//            }
//        }
//        for (Integer item : list) {
//            sb.append(item + " ");
//        }
//        System.out.println(sb.toString().trim());
//    }

//    static int runningTime(int[] arr) {
//        int buffer = 0;
//        int result = 0;
//        List<Integer> list = new ArrayList<>(arr.length);
//        for (int i: arr) {
//            list.add(i);
//        }
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (list.get(i) < list.get(j)) {
//                    buffer = list.get(i);
//                    list.remove(i);
//                    list.add(j, buffer);
//                    result += Math.abs(i - j);
//                }
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for (Integer item : list) {
//            sb.append(item + " ");
//        }
//        System.out.println(sb.toString().trim());
//
//        return result;
//
//    }

//    static int[] quickSort(int[] arr) {
//        List<Integer> result = new ArrayList<>();
//        List<Integer> left = new ArrayList<>();
//        List<Integer> right = new ArrayList<>();
//        int first = arr[0];
//        for (int item: arr) {
//            if (item < first) {
//                left.add(item);
//            } else if (item > first) {
//                right.add(item);
//            }
//        }
//        result.addAll(left);
//        result.add(first);
//        result.addAll(right);
//        int [] resultArray = new int [result.size()];
//        for (int i = 0; i < result.size(); i++) {
//            resultArray[i] = result.get(i);
//        }
//        return resultArray;
//    }

//    public int findDivisors(int num){
//        String strNum = Integer.toString(num);
//        int counter = 0;
//        for (int i = 0; i < strNum.length(); i++) {
//            if (i < strNum.length() - 1 && num % Integer.parseInt(strNum.substring(i, i+1)) == 0) {
//                counter++;
//            } else if (i == strNum.length() - 1 && num % Integer.parseInt(strNum.substring(i)) == 0) {
//                counter++;
//            }
//        }
//        return counter;
//    }

    public static Map<Character, List<String>> index(List<String> names) {
        Map<Character, List<String>> result = new HashMap<>();
        for (String name: names){
            if (!result.containsKey(name.charAt(0))) {
                List<String> listWithLetter = new ArrayList<>();
                listWithLetter.add(name);
                result.put(name.charAt(0), listWithLetter);
            } else {
                result.get(name.charAt(0)).add(name);
            }
        }
        return result;
    }

    public static class Trainer{
        private String name;
        private int id;

        public Trainer(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return name + " " + id + "\n";
        }
    }



    public static void main(String[] args) {

        List<Trainer> trainers = new ArrayList<>();
        List<Trainer> trainers2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            trainers.add(new Trainer("Trainer" + i + 1, (20 - i)));
        }
        trainers.add(new Trainer(null, 12));

        int sum1 = trainers.stream().reduce(0, (i,a) -> i + a.getId(), Integer::sum);




        System.out.println(sum1);
//        trainers.stream().forEach(trainers2::add);

//        System.out.println(trainers);
//        trainers.sort(Comparator.comparing(Trainer::getName, Comparator.nullsFirst(Comparator.naturalOrder())));
//        trainers.sort(Comparator.comparing(Trainer::getName, Comparator.nullsFirst(Comparator.naturalOrder())));
//        System.out.println(trainers);





    }
}
