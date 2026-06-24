class Solution {
   public int maxArea(int[] heights) {
        int low = 0;
        int high = heights.length - 1;
        int highestCapacity=-1;
        while(low < high){
            int minimumHeight = Math.min(heights[low], heights[high]);
            int areaCapacity = minimumHeight * (high - low);
            if(areaCapacity > highestCapacity){
                highestCapacity = areaCapacity;
            }

            if(heights[low] > heights[high]) {
                high--;
            } else {
                low++;
            }
        }
        return highestCapacity;
    }
}
