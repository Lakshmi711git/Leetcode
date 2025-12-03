class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Frequency map: stores the count of each character in the current window.
        // We use an array of size 128 for extended ASCII characters.
        int[] count = new int[128]; 
        int ans = 0; // The length of the longest substring found so far
        int n = s.length();
        int l = 0; // Left pointer of the sliding window

        // The right pointer 'r' expands the window
        for (int r = 0; r < n; ++r) {
            char c = s.charAt(r);
            // 1. Include the new character 'c' at position 'r'
            count[c]++; 

            // 2. If 'c' is a duplicate (count > 1), shrink the window from the left
            while (count[c] > 1) {
                // Remove the character at the left pointer 'l' from the window
                count[s.charAt(l)]--;
                // Move the left pointer to the right
                l++; 
            }

            // 3. Update the maximum length
            // The current window length is r - l + 1
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}