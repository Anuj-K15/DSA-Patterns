package Patterns.TwoPointers;

import java.util.Arrays;

public class TripletsWithSmallerSum {
    public static int countTriplets(int target, int arr[]) {
        // Step 1: Sort the array
        Arrays.sort(arr);

        // result stores the count of triplets with smaller sum
        int result = 0;

        int n = arr.length;

        // Step 2: Fix one element and use two pointers
        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            // Step 3: Move two pointers
            while (left < right) {

                // Current triplet sum
                int sum = arr[i] + arr[left] + arr[right];

                // move right pointer because we want sum to be smaller than target
                if(sum >= target) {
                    right--;
                } else {
                    result += (right - left);
                    left++;
                }
            }
        }
        // Step 6: Return the count of triplets with smaller sum
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 4, 7};
        int target = 12;
        System.out.print((countTriplets(target,arr)));
    }
}
