class MyStack {

 /** Initialize your data structure here. */

    LinkedList<Integer> queue = new LinkedList<>();

    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(0, x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}