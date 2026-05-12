package Patterns.TwoPointers;


import java.util.Arrays;
import java.util.Collections;

public class SquaresOfASortedArray {
    public static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
    public static int[] sqOfSortedArray(int[] arr){
        // count negative numbers
        int negCount = 0;
        for(int neg : arr){
            if(neg < 0){
                negCount++;
            }
        }

        //init variables and emmpty arrays
        int[] a = new int[negCount];
        int[] b = new int[arr.length - negCount];
        int i = 0;
        int j = 0;

        //segregate negative and non-negative numbers in array
        for(int k=0; k<arr.length; k++) {

            if (arr[k] < 0) {
                a[i] = arr[k];
                i++;
                continue;
            }
            b[j] = arr[k];
            j++;
        }

        //Square the negative array and reverse it
        for(int sq1=0; sq1<a.length; sq1++){
            a[sq1] = a[sq1] * a[sq1];
        }
        reverse(a);

        //square the non-negative array
        for(int sq2=0; sq2<b.length; sq2++){
            b[sq2] = b[sq2] * b[sq2];
        }

        //init new variables and new result array
        int left = 0;
        int right = 0;
        int n = a.length;
        int m = b.length;
        int[] result = new int[n+m];
        int idx = 0;

        //loop for comparing and adding elements when both arrays have numbers
        while(left < n && right < m){
            if(a[left] <= b[right]){
                result[idx] = a[left];
                left++;
                idx++;
            }
            else {
                result[idx] = b[right];
                right++;
                idx++;
            }
        }

        //loop for adding elements when 'b' array is out of bounds
        while(left < n){
            result[idx] = a[left];
            left++;
            idx++;
        }

        //loop for adding elements when 'a' array is out of bounds
        while(right < m){
            result[idx] = b[right];
            right++;
            idx++;
        }

        return result;
    }
    public static void main(String[] args) {
        //initiaize array
        int[] arr = {-10000,-9999,-7,-5,0,0,10000};
        System.out.println(Arrays.toString(sqOfSortedArray(arr)));
    }
}
