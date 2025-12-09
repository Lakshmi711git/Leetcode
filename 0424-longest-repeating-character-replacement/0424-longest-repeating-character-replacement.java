class Solution {
    public int characterReplacement(String s, int k) {
        // Array to store frequency count of each uppercase letter (A-Z)
        // Since the string consists only of uppercase English letters.
        int[] charFrequency = new int[26];
        int left = 0; // Left pointer of the sliding window
        int maxLength = 0; // The result: length of the longest valid substring
        int maxCount = 0; // Maximum frequency of any single character in the current window

        for (int right = 0; right < s.length(); right++) {
            // 1. Expand the window to the right and update frequency
            char currentChar = s.charAt(right);
            // Use 'A' as a reference to get the 0-25 index
            charFrequency[currentChar - 'A']++;

            // 2. Update the max frequency in the current window
            // maxCount only needs to increase. Once it's high, it maintains the
            // max potential window size, even if a new window's maxCount is lower.
            maxCount = Math.max(maxCount, charFrequency[currentChar - 'A']);

            // 3. Check for window validity
            // Condition for validity: window_size - max_frequency <= k
            // If it's invalid: window_size - max_frequency > k
            // Characters to replace = (right - left + 1) - maxCount
            if ((right - left + 1) - maxCount > k) {
                // Window is invalid, so we must shrink it from the left
                
                // Decrement the frequency of the character going out of the window
                char outgoingChar = s.charAt(left);
                charFrequency[outgoingChar - 'A']--;
                
                // Move the left pointer one step to the right
                left++;
            }

            // The window is always the longest valid window found so far 
            // because we only shrink it when absolutely necessary.
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}