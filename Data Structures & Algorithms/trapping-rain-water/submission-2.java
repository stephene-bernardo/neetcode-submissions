class Solution {
   public int trap(int[] height) {
        int sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<height.length;i++){
            if(!stack.isEmpty() && height[i] >= stack.peekLast()){
                int lower = Math.min(stack.peekLast(), height[i]);
                while(!stack.isEmpty()){
                    int currentElement = stack.pop();
                    if(lower > currentElement){
                        sum += lower - currentElement;
                    }
                }
            }
            stack.push(height[i]);
        }

        if(!stack.isEmpty()){
            int higherEdge = stack.pop();
            while(!stack.isEmpty() && higherEdge < stack.peek()){
                higherEdge = stack.pop();
            }
            if(!stack.isEmpty()){
                int lower = Math.min(higherEdge, stack.peekLast());
                while(!stack.isEmpty() && lower != 0){
                    int currentElement = stack.pop();
                    if(lower > currentElement){
                        sum += lower - currentElement;
                    }
                }
            }
        }

        return sum;
    }
}
