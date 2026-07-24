class Solution {
   public int[] dailyTemperatures(int[] temperatures) {
        Stack<TemperaturePosition> temperatureStacks= new Stack<>();
        int []res = new int[temperatures.length];
        for(int i=0; i< temperatures.length;i++){
            int temperature = temperatures[i];
            while(!temperatureStacks.isEmpty() && temperature > temperatureStacks.peek().temperature()){
                TemperaturePosition temperaturePosition = temperatureStacks.pop();

                res[temperaturePosition.position()] = i - temperaturePosition.position;
            }
            temperatureStacks.push(new TemperaturePosition(temperature, i));
        }
        return res;
    }

    record TemperaturePosition(int temperature, int position) { }
}
