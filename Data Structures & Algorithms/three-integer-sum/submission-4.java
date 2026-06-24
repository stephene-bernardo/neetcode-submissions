class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        Set<ArrayWrapper> listOfThreeSums = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int low = 0;
            int high = nums.length - 1;
            while((low < i || high > i) && (low != high && low < nums.length && high >= 0)){
                if(i==low){
                    low++;
                }else if(i==high){
                    high--;
                }
                int sum = (sortedNums[low] + sortedNums[high])*-1;
                if(sum < sortedNums[i]){
                    high--;
                } else if(sum > sortedNums[i]){
                    low++;
                } else if(sum == sortedNums[i]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(sortedNums[low]);
                    list.add(sortedNums[high]);
                    list.add(sortedNums[i]);
                    if(high > low){
                        listOfThreeSums.add(new ArrayWrapper(list.stream().sorted().toList()));
                    }
                    low++;
                }
            }

        }
        return listOfThreeSums.stream()
                .map(wrapper -> wrapper.data)
                .collect(Collectors.toList());
    }

    static record ArrayWrapper(List<Integer> data){
        public boolean equals(Object o){
            if(this == o){
                return true;
            }
            if(!(o instanceof ArrayWrapper that)){
                return false;
            }
            return this.data.equals(that.data);
        }
        public int hashCode(){
            return data.hashCode();
        }
    }
}
