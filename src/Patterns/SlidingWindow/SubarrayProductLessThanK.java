package Patterns.SlidingWindow;

import java.util.Arrays;
import java.util.Collections;

public class SubarrayProductLessThanK {
    public static int numSubarrayProductLessThanK(int[] arr, int k) {
        int low = 0;
        int high = 0;
        int count = 0;
        int product = 1;
        int n = arr.length;

        if (k <= 1) return 0;

        while (high < n){
            product = product * arr[high];
            while(product >= k){
                product /= arr[low++];
            }
            count = count + (high - low) + 1;
            high++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1};
        int k = 1;
        System.out.print(numSubarrayProductLessThanK(arr, k));
    }
}
