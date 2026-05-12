package Patterns.TwoPointers;

import java.util.Arrays;

public class Segregate0sand1s {
    public static void swap(int[] arr, int left, int right){
        int temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;
    }
    public static int[] segregate0and1(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            if(arr[left]==0 && arr[right]==1){
                left++;
                right--;
            }
            else if(arr[left]==1 && arr[right]==0){
                swap(arr,left,right);
                left++;
                right--;
            }
            else if(arr[left]==0 && arr[right]==0){
                left++;
            }
            else if(arr[left]==1 && arr[right]==1){
                right--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        System.out.print(Arrays.toString(segregate0and1(arr)));
    }
}
