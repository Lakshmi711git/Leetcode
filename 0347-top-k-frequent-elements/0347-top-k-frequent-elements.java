import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count Frequencies
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a Min-Heap (PriorityQueue) of size k.
        // It stores Map.Entry<Element, Frequency> and compares entries based on frequency.
        // (a, b) -> a.getValue() - b.getValue() creates a Min-Heap on the frequency (Value).
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        // Step 3: Maintain Top K
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            minHeap.offer(entry);
            
            if (minHeap.size() > k) {
                // If size exceeds k, remove the element with the lowest frequency
                minHeap.poll(); 
            }
        }

        // Step 4: Extract Result
        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = minHeap.poll().getKey();
        }
        
        // The elements are extracted from least frequent to most frequent due to min-heap structure,
        // so you might need to reverse the array if order is important, but for this problem, any order is usually fine.
        return topK;
    }
}