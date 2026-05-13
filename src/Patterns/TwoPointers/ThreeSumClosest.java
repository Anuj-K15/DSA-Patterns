package Patterns.TwoPointers;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSum(int[] nums, int target) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        // maxDiff stores the smallest difference found so far
        int minDiff = Integer.MAX_VALUE;

        // result stores the sum closest to the target
        int result = 0;

        int n = nums.length;

        // Step 2: Fix one element and use two pointers
        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            // Step 3: Move two pointers
            while (left < right) {

                // Current triplet sum
                int sum = nums[i] + nums[left] + nums[right];

                // Difference between current sum and target
                int diff = Math.abs(sum - target);

                // Step 4: Update closest result if needed
                if (diff < minDiff) {
                    minDiff = diff;
                    result = sum;
                }

                // Step 5: If exact match found, return immediately
                if (sum == target) {
                    return sum;
                }
                // If sum is smaller than target, increase left
                else if (sum < target) {
                    left++;
                }
                // If sum is larger than target, decrease right
                else {
                    right--;
                }
            }
        }

        // Step 6: Return the closest sum (not the difference)
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        System.out.println(threeSum(nums, target)); // Output: 2
    }
}