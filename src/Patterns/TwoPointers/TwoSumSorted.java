package Patterns.TwoPointers;

import java.util.Arrays;

public class TwoSumSorted {

    // Function to find two numbers in a sorted array whose sum equals the target
    public static int[] twoSum(int[] nums, int target) {

        // Initialize two pointers:
        // left starts from the beginning of the array
        // right starts from the end of the array
        int left = 0;
        int right = nums.length - 1;

        // Continue until the two pointers meet
        while (left < right) {

            // Calculate the sum of the two current elements
            int sum = nums[left] + nums[right];

            // Case 1: If the sum matches the target,
            // return the two numbers
            if (sum == target) {
                return new int[] { nums[left], nums[right] };
            }

            // Case 2: If the sum is smaller than the target,
            // move the left pointer to the right
            // to increase the sum
            else if (sum < target) {
                left++;
            }

            // Case 3: If the sum is greater than the target,
            // move the right pointer to the left
            // to decrease the sum
            else if (sum > target) {
                right--;
            }
        }

        // If no pair is found, return an empty array
        return new int[] {};
    }

    public static void main(String[] args) {

        // Input sorted array
        int[] nums = {2, 7, 11, 15};

        // Target sum to find
        int target = 9;

        // Call the twoSum function and print the result
        // Expected Output: [2, 7]
        System.out.print(Arrays.toString(twoSum(nums, target)));
    }
}