package Patterns.SlidingWindow;

public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] arr) {
        int low = 0;
        int high = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int n = arr.length;

        while(high < n){
            sum += arr[high];
            while(sum >= target){
                int len = high - low + 1;
                result = Math.min(result, len);
                sum -= arr[low];
                low++;
            }
            high++;
        }
        if(result == Integer.MAX_VALUE){
            return 0;
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,4};
        int target = 4;
        System.out.print(minSubArrayLen(target, arr));
    }
}
