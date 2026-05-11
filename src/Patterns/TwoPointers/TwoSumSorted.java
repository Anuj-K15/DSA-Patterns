package Patterns.TwoPointers;

import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                return new int[] {nums[left], nums[right]};
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.print(Arrays.toString(twoSum(nums, target)));
    }
}
