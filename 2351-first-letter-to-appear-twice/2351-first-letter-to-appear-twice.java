class Solution {
    public char repeatedCharacter(String s) {
        
        Set<Character> st = new HashSet<>();
        
        for(char x: s.toCharArray()){
            
            if(!st.contains(x)){
                st.add(x);
            }
            else{
                return x;
            }
        }
        return '0';
    }
}