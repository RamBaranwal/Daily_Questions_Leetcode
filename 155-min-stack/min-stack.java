class MinStack {
    private int[] stack;
    private int size;
    private int capacity;
    public MinStack() {
        size = 0;
        capacity = 2;
        stack = new int[capacity];
    }
    private void grow(){
        capacity = 2 * capacity;
        int[] newArr = new int[capacity];
        for(int i = 0; i < size; i++){
            newArr[i] = stack[i];
        }
        stack = newArr;
    }
    public void push(int value) {
        if(capacity == size){
            grow();
        }
        stack[size] = value;
        size++;
    }
    
    public void pop() {
        if(size > 0){
            size--;
        }
    }
    
    public int top() {
        return stack[size - 1];
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < size; i++){
            if(min > stack[i]){
                min = stack[i];
            }
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */