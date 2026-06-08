class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> integerFrequency = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            integerFrequency.compute(nums[i], (key, oldValue) ->  oldValue == null? 1: oldValue + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(integerFrequency.get(b), integerFrequency.get(a))
        );

        maxHeap.addAll(integerFrequency.keySet());
        
        int[] result = new int[k];
        
        
        for(int j=0; j < k; j++){
            result[j] =  maxHeap.poll();
        }

        return result;
    }
}
