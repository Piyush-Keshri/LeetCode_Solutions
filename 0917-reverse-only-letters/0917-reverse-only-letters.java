class Solution {
    public String reverseOnlyLetters(String s) {
        
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isLetter(ch)){
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            
            char ch = s.charAt(i);
            
            if(Character.isLetter(ch)){
                sb.append(st.pop());
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}