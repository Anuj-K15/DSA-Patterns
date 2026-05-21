package Patterns.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> freq = new HashMap<>();

        int low = 0;
        int res = -1;   // Return -1 if no substring contains exactly k unique characters
        int n = fruits.length;

        for (int high = 0; high < n; high++) {

            int current = fruits[high];

            // Increase frequency of current character
            freq.put(current, freq.getOrDefault(current, 0) + 1);

            // Shrink window until unique characters become <= k
            while (freq.size() > 2) {
                int leftNum = fruits[low];

                freq.put(leftNum, freq.get(leftNum) - 1);

                if (freq.get(leftNum) == 0) {
                    freq.remove(leftNum);
                }

                low++;
            }

            // Update answer when exactly k unique characters are present
            if (freq.size() <= 2) {
                int windowLength = high - low + 1;
                res = Math.max(res, windowLength);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[] fruits = {0,1,2,2};
        System.out.print(totalFruit(fruits));
    }
}
