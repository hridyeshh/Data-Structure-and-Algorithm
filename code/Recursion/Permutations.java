package Recursion;
import java.util.*;
public class Permutation {
    public static void permutations(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutations(f + ch + s, up.substring(1));
        }
    }

    public static void pad(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }
        int digit = up.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            pad(p + ch, up.substring(1));
        }
    }

    public static List<String> letterCombinations(String digits) {
        return padRet("",digits);
    }
    public static List<String> padRet(String p, String up) {
        if (up.isEmpty()) {
            List<String> current = new ArrayList<>();
            current.add(p);
            return current;
        }
        int ch = up.charAt(0) - '0';
        List<String> list = new ArrayList<>();
        for (int i = (ch - 2) * 3; i < ch * 3; i++) {
            char character = (char) ('a' + i);
            list.addAll(padRet(p + character, up.substring(1)));
        }
        return list;
    }
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        if ((n&1)==0) {
            double temp = myPow(x, n / 2);
            return temp * temp;
        } else {
            double temp = myPow(x, (n - 1) / 2);
            return x * temp * temp;
        }
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        generateSubsetSum(arr,N,0,0,result);
        return result;
    }
    // the main array where the elements are present and the subset array where the sum of subset will be stored
    public static void generateSubsetSum(ArrayList<Integer> arr, int N, int index, int currentSum, ArrayList<Integer> subset){
        if(index==N){
            subset.add(currentSum);
            return;
        }
        generateSubsetSum(arr,N, index+1,currentSum+arr.get(index),subset);
        generateSubsetSum(arr,N,index+1,currentSum,subset);
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
    }
}
