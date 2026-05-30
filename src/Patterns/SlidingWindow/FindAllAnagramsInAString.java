package Patterns.SlidingWindow;

import java.util.*;

public class FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();

        if (s.length() < p.length()) return list;

        int[] have = new int[26];
        int[] needed = new int[26];

        for (int i = 0; i < p.length(); i++) {
            needed[p.charAt(i) - 'a']++;
        }

        int low = 0;
        int n = p.length();

        for (int high = 0; high < s.length(); high++) {

            have[s.charAt(high) - 'a']++;

            if (high - low + 1 > n) {
                have[s.charAt(low) - 'a']--;
                low++;
            }

            if (high - low + 1 == n) {
                if (Arrays.equals(have, needed)) {
                    list.add(low);
                }
            }
        }

        return list;
    }
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s,p));
    }
}
