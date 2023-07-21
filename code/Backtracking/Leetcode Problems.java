package Backtracking;
import java.util.*;
public class Problems {
    public static boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for (int i = 0; i < cleanedString.length() - 1; i++) {
            if(cleanedString.charAt(i) != cleanedString.charAt(cleanedString.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        makeSubset(nums,0, new ArrayList<>(), list);
        return list;
    }
    public static void makeSubset(int[] nums, int s, List<Integer> list, List<List<Integer>> finalList) {
        finalList.add(new ArrayList<>(list));

        for (int i = s; i < nums.length; ++i) {
            if(i!=s && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            makeSubset(nums, i + 1, list, finalList);
            list.remove(list.size() - 1);
        }
    }

    private static void subset(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> finalList){
        if(list.size() == nums.length){
            finalList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]){
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            subset(nums,used,list,finalList);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }

    private static void subsetUnique(int[] nums,  boolean[] used, List<Integer> list, List<List<Integer>> finalList){
        if(list.size() == nums.length){
            finalList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            Arrays.sort(nums);
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            subsetUnique(nums, used, list, finalList);
            list.remove(list.size() - 1);
            used[i] = false;
        }

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subset(nums, new boolean[nums.length], new ArrayList<>(),list);
        return list;
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsetUnique(nums, new boolean[nums.length], new ArrayList<>(), list);
        return list;
    }

    private static boolean check(long N){
        boolean has3 = false;
        boolean has5 = false;
        boolean has7 = false;

        while(N>0){
            int digit = (int)(N%10);
            if(digit==3){
                has3 = true;
            }
            else if(digit==5){
                has5 = true;
            }
            else if(digit==7){
                has7 = true;
            }
            else{
                return false;
            }
            N/=10;
        }
        return has3 && has5 && has7;
    }

    private static int countShiNumber(int N, long currentNumber){
        if(currentNumber > N){
            return 0;
        }
        boolean isShi = check(currentNumber);

        int count = isShi ? 1:0;
        count += countShiNumber(N,currentNumber*10+3);
        count += countShiNumber(N,currentNumber*10+5);
        count += countShiNumber(N,currentNumber*10+7);
        return count;
    }

    public static int countShi(int N){
        return countShiNumber(N,0);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        return combination(0, candidates,target, new ArrayList<>(),list);
    }
    public static List<List<Integer>> combination(int s, int[] nums, int target, List<Integer> list, List<List<Integer>> finalList ){
        if(target < 0) return new ArrayList<>();
        if(target==0){
            finalList.add(new ArrayList<>(list));
        }


        for (int i = s; i < nums.length; i++) {
            Arrays.sort(nums);
            if (i>s && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            combination(i+1,nums, target - nums[i], list, finalList);
            list.remove(list.size() - 1);

        }
        return finalList;
    }


    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        System.out.println(combinationSum(arr, 8));
    }
}

