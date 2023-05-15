class Solution {
    public String longestPalindrome(String s) {
       
        if(s.length()<2){
            return s;
        }
        
        String res = "";
        
        for(int i=0;i < s.length();i++){
            
            String odd = getPalindrome(s,i,i);
            
            if(odd.length() > res.length()){
                res = odd;
            }
            
            String even = getPalindrome(s,i,i+1);
            
            if(even.length() > res.length()){
                res = even;
            }
            
        }
        
        return res;
    }
    
    public String getPalindrome(String str,int start,int end){
        // String str1 = str;
        while(start>=0 && end<str.length() && str.charAt(start) == str.charAt(end)){
            
            start--;
            end++;
            
        }
        return str.substring(start+1,end);
    }
    
    
}