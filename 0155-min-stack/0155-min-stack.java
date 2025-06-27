class MinStack {

    Stack<Integer> st = new Stack<>();
    Stack<Integer> minSt = new Stack<>();

    public MinStack() {
        minSt.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        st.push(val);
        minSt.push(Math.min(val,minSt.peek()));
        
    }
    
    public void pop() {
        if(!st.empty()){
            st.pop();
            minSt.pop();
        }
    }
    
    public int top() {
        if(!st.empty()){
            return st.peek();
        }
        return -1;
    }
    
    public int getMin() {
        if(!st.empty()){
            return minSt.peek();
        }
        return Integer.MAX_VALUE;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */