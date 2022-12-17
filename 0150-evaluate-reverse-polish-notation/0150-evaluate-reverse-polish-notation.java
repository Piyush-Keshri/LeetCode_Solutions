class Solution {
    public int evalRPN(String[] tokens) {
    
        int a,b;
        
        Stack<Integer> S = new Stack<Integer>();
        for(String token : tokens){
            
            if(token.equals("+")){
                S.add(S.pop()+S.pop());
            }
            
            else if(token.equals("-")){
               b = S.pop();
               a = S.pop();
                
               S.add(a-b); 
            }
            else if(token.equals("*")){
               b = S.pop();
               a = S.pop();
                
               S.add(b*a); 
            }
            else if(token.equals("/")){
               b = S.pop();
               a = S.pop();
                
               S.add(a/b); 
            }
            
            else {
                S.add(Integer.parseInt(token));
            }
        }
        return S.pop();
    }
}