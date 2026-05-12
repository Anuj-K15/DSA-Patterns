package Patterns.TwoPointers;

import java.sql.SQLOutput;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] arr){
        int officer = 0;
        int cm = 1;
        int res = 1;
        int n = arr.length;
        while(cm < n){
            if(arr[cm] == arr[cm-1]){
                cm++;
                continue;
            }
            arr[officer+1] = arr[cm];
            officer++;
            cm++;
            res++;
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(arr));
    }
}
