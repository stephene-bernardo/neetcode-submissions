class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> differenceByIndex = new HashMap();
        differenceByIndex.put(nums[0], 0);        
        int i = 1;
        do {
            if(differenceByIndex.containsKey(target-nums[i])){
                return new int[]{differenceByIndex.get(target-nums[i]), i};
            } else{
                differenceByIndex.put(nums[i], i);   
            }
            i++;
        } while(i < nums.length);
        return new int[]{0,0};
    }
}
