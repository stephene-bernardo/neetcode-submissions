
class Solution {
      public static Set<String> mathOperations = new HashSet<>();

    public static final String ADDITION_OPERATOR = "+";

    public static final String SUBSTRACTION_OPERATOR = "-";

    public static final String MULTIPLICATION_OPERATOR = "*";

    public static final String DIVISION_OPERATOR = "/";

    static {
        mathOperations.add(ADDITION_OPERATOR);
        mathOperations.add(SUBSTRACTION_OPERATOR);
        mathOperations.add(MULTIPLICATION_OPERATOR);
        mathOperations.add(DIVISION_OPERATOR);
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens){
            if(mathOperations.contains(token)){
                int second = stack.pop();
                int first = stack.pop();
                int result = switch (token) {
                    case ADDITION_OPERATOR -> first + second;
                    case SUBSTRACTION_OPERATOR -> first - second;
                    case MULTIPLICATION_OPERATOR -> first * second;
                    case DIVISION_OPERATOR -> first / second;
                    default -> 0;
                };
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
