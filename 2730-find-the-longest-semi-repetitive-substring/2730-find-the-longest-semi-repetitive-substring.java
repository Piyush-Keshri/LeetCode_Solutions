class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        
        int ans = 0;
        
        for(int i=0;i<s.length();i++){
            StringBuilder str = new StringBuilder();
            for(int j=i;j<s.length();j++){
                
                str.append(s.charAt(j));
                if(isValid(str.toString())){
                    
                    ans = Math.max(ans,j-i+1);
                    
                }
                
            }
            
        }
        return ans;
        
    }
    
    public boolean isValid(String s){
        
        int pairs = 0;
        
        for(int i=1;i<s.length();i++){
            
            if(s.charAt(i) == s.charAt(i-1)){
                pairs++;
            }
            
        }
        
        return pairs<=1;
    }
    
}