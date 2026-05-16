package Patterns.TwoPointers;

import java.util.Arrays;

public class DutchNationalFlag {

    // Function to swap two elements in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function to sort an array containing only 0s, 1s, and 2s
    public static int[] dutchNationalFlag(int[] arr) {

        int n = arr.length;

        // low  -> position where next 0 should be placed
        // mid  -> current element being examined
        // high -> position where next 2 should be placed
        int low = 0;
        int mid = 0;
        int high = n - 1;

        // Continue until mid crosses high
        while (mid <= high) {

            // Case 1: Current element is 0
            // Swap it with the element at low
            // Then move both low and mid forward
            if (arr[mid] == 0) {
                swap(arr, mid, low);
                low++;
                mid++;
            }

            // Case 2: Current element is 1
            // 1 is already in the correct middle region
            // Just move mid forward
            else if (arr[mid] == 1) {
                mid++;
            }

            // Case 3: Current element is 2
            // Swap it with the element at high
            // Decrease high only
            // Do NOT increment mid because the swapped value
            // from high needs to be checked again
            else if (arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            }
        }

        // Return the sorted array
        return arr;
    }

    public static void main(String[] args) {

        // Input array containing only 0s, 1s, and 2s
        int[] arr = {2, 0, 1};

        // Print sorted array
        // Expected Output: [0, 1, 2]
        System.out.print(Arrays.toString(dutchNationalFlag(arr)));
    }
}