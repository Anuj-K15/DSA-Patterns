package Patterns.TwoPointers;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumUnsorted {
    public static int[] twoSumUnsorted(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{map.get(result), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        System.out.print(Arrays.toString(twoSumUnsorted(nums, target)));
    }
}
