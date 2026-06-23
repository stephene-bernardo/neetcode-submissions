class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int highIndex = numbers.length - 1;
        int lowIndex = 0;

        while(lowIndex < numbers.length - 1 && highIndex >=0){
            int sum = numbers[highIndex] + numbers[lowIndex];
            if(target < sum){
                highIndex--;
            } else if(target > sum) {
                lowIndex++;
            } else {
                return new int[]{lowIndex+1, highIndex+1};
            }
        }
        return null;
    }
}
