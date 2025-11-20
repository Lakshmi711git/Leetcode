class Solution {
    /**
     * Finds the number of subarrays whose sum is divisible by k.
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     */
    public int subarraysDivByK(int[] nums, int k) {
        // remainderCounts[r] stores the number of prefix sums encountered so far
        // that have a remainder 'r' when divided by k.
        // The size k is used because the remainder r must be in the range [0, k-1].
        int[] remainderCounts = new int[k];
        
        // A prefix sum of 0 (before processing any element) has a remainder of 0.
        // This handles subarrays starting from index 0.
        remainderCounts[0] = 1;
        
        int currentPrefixSum = 0;
        int count = 0;
        
        for (int num : nums) {
            // 1. Update the running prefix sum
            currentPrefixSum += num;
            
            // 2. Calculate the remainder.
            // (currentPrefixSum % k) can be negative if currentPrefixSum is negative.
            // Adding k ensures the remainder is always non-negative, and the modulo k 
            // operation keeps it in the range [0, k-1].
            int remainder = currentPrefixSum % k;
            if (remainder < 0) {
                remainder += k;
            }
            
            // 3. Count subarrays.
            // If remainder 'r' has been seen 'c' times before (remainderCounts[r] = c),
            // then the current prefix sum (which also has remainder 'r') forms 'c' 
            // new valid subarrays with the previous 'c' positions.
            count += remainderCounts[remainder];
            
            // 4. Update the count for the current remainder
            remainderCounts[remainder]++;
        }
        
        return count;
    }
}