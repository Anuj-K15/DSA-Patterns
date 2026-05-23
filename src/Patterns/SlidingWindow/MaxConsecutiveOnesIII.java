package Patterns.SlidingWindow;

public class MaxConsecutiveOnesIII {
    public static int longestOnes(int[] nums, int k) {
        int low = 0;
        int res = 0;
        int zeroCount = 0;
        for(int high = 0; high<nums.length; high++){
            if(nums[high] == 0){
                zeroCount++;
            }
            while(zeroCount > k){
                if(nums[low] == 0){
                    zeroCount--;
                }
                low++;
            }
            int len = high - low + 1;
            res = Math.max(res, len);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.print(longestOnes(nums, k));
    }
}
