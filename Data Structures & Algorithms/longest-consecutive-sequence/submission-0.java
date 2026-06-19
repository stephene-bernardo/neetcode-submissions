class Solution {
   public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> unionSeq = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            unionSeq.put(nums[i], null);
        }
        for(int key: unionSeq.keySet()){
            int keyMinusOne = key - 1;
            if(unionSeq.containsKey(keyMinusOne)){
                unionSeq.put(keyMinusOne, key);
            }
        }
        int highestSequence = 0;

        for(Integer seq: unionSeq.keySet()){
            int i = sequenceCount(unionSeq, seq);
            if(highestSequence < i){
                highestSequence = i;
            }
        }
        return highestSequence;
    }
    int sequenceCount(Map<Integer, Integer> unionSeq, int currentValue){
        if(!unionSeq.containsKey(currentValue)){
            return 1;
        } else if(unionSeq.get(currentValue) == null){
            return 1;
        }
        return  1 + sequenceCount(unionSeq, unionSeq.get(currentValue));
    }
}
