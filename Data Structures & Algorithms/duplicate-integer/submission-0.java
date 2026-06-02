class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> cacheEntry = new HashSet();
        
        for(int num: nums){
           if(cacheEntry.contains(num)){
            return true;  
           } 
           else {
            cacheEntry.add(num);
           }
        }
        return false;
    }
}