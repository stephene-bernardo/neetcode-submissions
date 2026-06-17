class Solution {
    public int[] productExceptSelf(int[] nums) {
        List<Integer> prefixProduct = new ArrayList<>();
        int product = 0;
        for(int i=0; i < nums.length; i++){
            if(i == 0){
                product = nums[i];
            } else {
                product *= nums[i];
            }
            prefixProduct.add(product);
        }
        product = 0;
        List<Integer> suffixProduct = new ArrayList<>();
        for(int j=nums.length-1; j>= 0; j--) {
            if(j == nums.length - 1){
                product = nums[j];
            } else {
                product *= nums[j];
            }
            suffixProduct.add(product);
        }

        int[] results = new int[nums.length];
        for(int k=0; k < nums.length;k++){
            if(k == 0) {
                results[k] = suffixProduct.get(nums.length - 2);
            } else if(k == nums.length -1){
                results[k] = prefixProduct.get(nums.length - 2);
            } else{
                results[k] = prefixProduct.get(k-1) * suffixProduct.get(nums.length - k - 2);
            }
        }
        return results;
    }
}  
