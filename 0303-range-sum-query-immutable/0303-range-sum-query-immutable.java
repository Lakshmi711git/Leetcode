class NumArray {
    // The prefixSum array is stored as a member variable.
    // prefixSum[i] stores the sum of nums[0] + ... + nums[i-1].
    private int[] prefixSum;

    /**
     * Constructor: Calculates and stores the prefix sum array.
     * Time Complexity for construction: O(N)
     */
    public NumArray(int[] nums) {
        // The prefixSum array will have size nums.length + 1
        // to handle the base case where sum up to index -1 is 0.
        prefixSum = new int[nums.length + 1];
        
        // P[0] is initialized to 0.
        for (int i = 0; i < nums.length; i++) {
            // P[i+1] = P[i] + nums[i]
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    /**
     * Method: Computes the sum of elements from index left to index right (inclusive).
     * Time Complexity for query: O(1)
     */
    public int sumRange(int left, int right) {
        // Sum(left, right) = P[right + 1] - P[left]
        return prefixSum[right + 1] - prefixSum[left];
    }
}

/**
 * Example Usage:
 * * int[] nums = {-2, 0, 3, -5, 2, -1};
 * NumArray obj = new NumArray(nums);
 * * obj.sumRange(0, 2); // returns 1 ((-2) + 0 + 3)
 * obj.sumRange(2, 5); // returns -1 (3 + (-5) + 2 + (-1))
 * obj.sumRange(0, 5); // returns -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 */