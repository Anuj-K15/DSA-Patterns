package Patterns.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {

        // Har character ki frequency store karne ke liye array
        int[] freq = new int[26];

        // Sliding window ke pointers
        int low = 0, high = 0;

        // Final maximum answer store karega
        int res = 0;

        int n = s.length();

        // Current window me sabse jyada baar aane wale character ki frequency
        int maxCount = 0;

        // Window ko expand karne ke liye high pointer move karenge
        for (high = 0; high < n; high++) {

            // Current character
            char curr = s.charAt(high);

            // Current character ki frequency increase karo
            freq[curr - 'A']++;

            // Maximum repeating character frequency update karo
            maxCount = Math.max(maxCount, freq[curr - 'A']);

            // Current window length
            int len = high - low + 1;

            // Agar replace karne wale characters k se jyada ho gaye
            // to window shrink karo
            while ((high - low + 1) - maxCount > k) {

                // Left side character ki frequency decrease karo
                char leftChar = s.charAt(low);
                freq[leftChar - 'A']--;

                // Low pointer aage badhao
                low++;
            }

            // Valid window ka updated length
            len = high - low + 1;

            // Maximum valid substring length store karo
            res = Math.max(len, res);
        }

        // Final answer return karo
        return res;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.print(characterReplacement(s, k));
    }
}
