class Solution {
    public String replaceDigits(String s) {
        String ans = "";
        for(int i=0;i<s.length();i++){
            
            if(i%2 == 0){
                ans+=s.charAt(i);
            }
            else{
                int add = s.charAt(i)-'0';
                char ch = (char)(s.charAt(i-1)+add);
                ans+=ch;
            }
            
        }
        return ans;
    }
}