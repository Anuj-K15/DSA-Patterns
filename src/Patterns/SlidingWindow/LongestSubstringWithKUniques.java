package Patterns.SlidingWindow;

import java.util.Map;
import java.util.HashMap;


public class LongestSubstringWithKUniques {
    public static int longestKSubstr(String s, int k) {

        Map<Character, Integer> freq = new HashMap<>();

        int low = 0;
        int res = -1;   // Return -1 if no substring contains exactly k unique characters
        int n = s.length();

        for (int high = 0; high < n; high++) {

            char current = s.charAt(high);

            // Increase frequency of current character
            freq.put(current, freq.getOrDefault(current, 0) + 1);

            // Shrink window until unique characters become <= k
            while (freq.size() > k) {
                char leftChar = s.charAt(low);

                freq.put(leftChar, freq.get(leftChar) - 1);

                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }

                low++;
            }

            // Update answer when exactly k unique characters are present
            if (freq.size() == k) {
                int windowLength = high - low + 1;
                res = Math.max(res, windowLength);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.print(longestKSubstr(s,k));
    }
}
