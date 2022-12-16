class MyQueue {
// STEP  1: 
Stack<Integer> mainStack = new Stack<Integer>();
Stack<Integer> tempStack = new Stack<Integer>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
      mainStack.push(x);  
    }
    
    public int pop() {
     int result = -1;
// STEP  2, 3: 
    if(!mainStack.isEmpty()){
// STEP  4: 
       transferStackData(mainStack, tempStack);
       result = tempStack.pop();
// STEP  5: 
        transferStackData(tempStack, mainStack);
     }
     return result;
    }
    
    public int peek() {
      int result = -1;
    if(!mainStack.isEmpty()){
        transferStackData(mainStack, tempStack);
        result = tempStack.peek();
        transferStackData(tempStack, mainStack);
     }
     return result;
    }
    
    public boolean empty() {
        return mainStack.isEmpty();
    }


// Common function for copy data from Stack1 to Stack2
    private void transferStackData(Stack<Integer> s1, Stack<Integer> s2){
        if(s1.isEmpty() && s2.isEmpty())
          return;

          while(!s1.isEmpty()){
            int element = s1.pop();
            s2.push(element);
          }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */