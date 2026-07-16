class Solution {
    public static final char OPEN_BRACKET = '(';
    public static final char OPEN_CURLY_BRACKET = '{';
    public static final char OPEN_SQUARE_BRACKET = '[';

    private static final Map<Character, Character> CLOSE_BY_OPEN_BRACKET_PAIR = new HashMap<>();
    static {
        CLOSE_BY_OPEN_BRACKET_PAIR.put(')', OPEN_BRACKET);
        CLOSE_BY_OPEN_BRACKET_PAIR.put('}', OPEN_CURLY_BRACKET);
        CLOSE_BY_OPEN_BRACKET_PAIR.put(']', OPEN_SQUARE_BRACKET);
    }

    private final static Set<Character> OPEN_BRACKETS = new HashSet<>();
    static {
        OPEN_BRACKETS.add(OPEN_BRACKET);
        OPEN_BRACKETS.add(OPEN_CURLY_BRACKET);
        OPEN_BRACKETS.add(OPEN_SQUARE_BRACKET);
    }


    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();



        if(s.length() <= 1){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(CLOSE_BY_OPEN_BRACKET_PAIR.containsKey(s.charAt(i))){
                Character opening = CLOSE_BY_OPEN_BRACKET_PAIR.get(s.charAt(i));
                if(opening == stack.peekLast() && !stack.isEmpty()) {
                    stack.removeLast();
                } else {
                    return false;
                }
            } else if(OPEN_BRACKETS.contains(s.charAt(i))) {
                stack.add(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
