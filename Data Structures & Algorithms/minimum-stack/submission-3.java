
class MinStack {
       private final List<Integer> stack;
    public MinStack() {
        stack = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);
    }

    public void pop() {
        stack.removeLast();
    }

    public int top() {
        return stack.isEmpty()? 0:  stack.getLast();
    }

    public int getMin() {
        return stack.stream().min(Integer::compare).orElse(0);
    }
}
