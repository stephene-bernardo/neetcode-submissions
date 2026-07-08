class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> maxSliding = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int left =0, right =0;
        while(right < nums.length){
            if((right-left)+1 == k) {
                priorityQueue.add(nums[right]);
                maxSliding.add(priorityQueue.peek());
            }
            else if((right-left) == k){
                priorityQueue.remove(nums[left]);
                priorityQueue.add(nums[right]);
                maxSliding.add(priorityQueue.peek());
                left++;
            }
            else{
                priorityQueue.add(nums[right]);
            }
            right++;
        }
        return  maxSliding.stream().mapToInt(Integer::intValue).toArray();
    }
}
