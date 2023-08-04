class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int i=0;
        int j=0;
        int ans = 0;
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        while(j<s.length()){
            
            char ch = s.charAt(j);
            
            if(map.containsKey(ch)){
                i = Math.max(map.get(ch)+1,i);
            }
            
            map.put(ch,j);
            
            ans = Math.max(ans,j-i+1);
            
            j++;
        }
        
        return ans;
    }
}