package Patterns.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> freq = new HashMap<>();

        int low = 0;
        int res = 0;   // Return 0 if no substring contains exactly k unique characters
        int n = s.length();

        for (int high = 0; high < n; high++) {
            char current = s.charAt(high);

            // Increase frequency of current character
            freq.put(current, freq.getOrDefault(current, 0) + 1);
            int k = high - low + 1;

            // Shrink window until unique characters become >= k
            while (freq.size() < k) {
                char leftChar = s.charAt(low);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                low++;
                k = high - low + 1;
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
        String s = "abcabcbb";
        System.out.print(lengthOfLongestSubstring(s));
    }
}
