package Patterns.TwoPointers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        // create a list to store the result
        List<List<Integer>> result = new ArrayList<>();

        //sort the array
        Arrays.sort(nums);
        int n = nums.length;

        //loop from 0 -> n-2
        for(int i = 0; i < n - 2; i++){
            // if 2nd element is duplicate then ignore it and continue
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            // initialize pointers
            int left = i+1;
            int right = n-1;
            // simple formula for calculation
            int sum = -1 * nums[i];

            // loop till left < right
            while(left < right){
                //sum up and store in s
                int s = nums[left] + nums[right];

                // if equal then store into result and inc,dec pointers
                if(s == sum){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // if duplicate ignore and increment
                    while(left < n && nums[left] == nums[left-1]){
                        left++;
                    }
                    // if duplicate ignore and decrement
                    while(right >= 0 && nums[right] == nums[right+1]){
                        right--;
                    }

                // s less than sum increment left
                } else if (s < sum) {
                    left++;

                // s greater than sum decrement right;
                } else {
                    right--;
                }
            }
        }
        // return result
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println((threeSum(nums)));
    }


}
