import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        // Map to store the count of each fruit type in the current window (basket)
        Map<Integer, Integer> basket = new HashMap<>();
        
        int left = 0;
        int maxLength = 0;
        
        // Iterate with the 'right' pointer to expand the window
        for (int right = 0; right < fruits.length; right++) {
            
            // 1. Expand Window: Add the fruit entering the window
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);
            
            // 2. Contract Window: Check if we have more than 2 fruit types
            while (basket.size() > 2) {
                int leftFruit = fruits[left];
                
                // Decrement the count of the fruit leaving the window
                basket.put(leftFruit, basket.get(leftFruit) - 1);
                
                // If the count drops to 0, remove the fruit type from the map
                if (basket.get(leftFruit) == 0) {
                    basket.remove(leftFruit);
                }
                
                // Move the left pointer forward
                left++;
            }
            
            // 3. Update Maximum: Record the maximum length of the valid window
            // (right - left + 1) is the current window size
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}