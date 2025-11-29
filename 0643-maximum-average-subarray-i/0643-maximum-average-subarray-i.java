class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Use double for precision, although intermediate sums can be large integers.
        // It's safer to use double for the sum calculation to avoid potential overflow 
        // if using a standard 'int', though 'long' would also work for the sum.
        double currentSum = 0;

        // 1. Initialization: Calculate the sum of the first window (indices 0 to k-1)
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        double maxSum = currentSum;

        // 2. Sliding the Window: Start from the element entering the window (index k)
        for (int i = k; i < nums.length; i++) {
            // Add the new element entering the right side of the window (nums[i])
            currentSum += nums[i];

            // Subtract the element leaving the left side of the window (nums[i - k])
            currentSum -= nums[i - k];

            // Update the maximum sum found so far
            maxSum = Math.max(maxSum, currentSum);
        }

        // 3. Final Result: Return the maximum sum divided by k to get the maximum average
        return maxSum / k;
    }
}
