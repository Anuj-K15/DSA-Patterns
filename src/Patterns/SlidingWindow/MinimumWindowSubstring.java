package Patterns.SlidingWindow;

import java.util.Arrays;

public class MinimumWindowSubstring {
    private static boolean sahi(int[] have, int[] needed){
        for(int i=0; i<256; i++){
            if(have[i] < needed[i]) return false;
        }
        return true;
    }
    public static String minWindow(String s, String t) {
        int[] have = new int[256];
        int[] needed = new int[256];

        for(int i=0; i<t.length(); i++){
            needed[t.charAt(i)]++;
        }

        int low = 0, high = 0;
        int res = Integer.MAX_VALUE;
        int n = s.length();
        int start = 0;

        for (high = 0; high < n; high++) {
            have[s.charAt(high)]++;

            while (sahi(have, needed)) {
                int len = high - low + 1;
                if (len < res) {
                    res = len;
                    start = low;
                }
                have[s.charAt(low)]--;
                low++;
            }
//            return s.substring(start, res);
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(start, start + res);
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "BANC";
        System.out.print(minWindow(s,t));
    }
}
